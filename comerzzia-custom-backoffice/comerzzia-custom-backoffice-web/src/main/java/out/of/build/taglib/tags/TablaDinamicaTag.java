/**
 * ComerZZia 3.0 Copyright (c) 2008-2015 Comerzzia, S.L. All Rights Reserved. THIS WORK IS SUBJECT TO SPAIN AND
 * INTERNATIONAL COPYRIGHT LAWS AND TREATIES. NO PART OF THIS WORK MAY BE USED, PRACTICED, PERFORMED COPIED,
 * DISTRIBUTED, REVISED, MODIFIED, TRANSLATED, ABRIDGED, CONDENSED, EXPANDED, COLLECTED, COMPILED, LINKED, RECAST,
 * TRANSFORMED OR ADAPTED WITHOUT THE PRIOR WRITTEN CONSENT OF COMERZZIA, S.L. ANY USE OR EXPLOITATION OF THIS WORK
 * WITHOUT AUTHORIZATION COULD SUBJECT THE PERPETRATOR TO CRIMINAL AND CIVIL LIABILITY. CONSULT THE END USER LICENSE
 * AGREEMENT FOR INFORMATION ON ADDITIONAL RESTRICTIONS.
 */
/**
 * 
 */
package com.comerzzia.taglib.tags;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.core.util.i18n.Translation;
import com.comerzzia.taglib.WebKeys;

public class TablaDinamicaTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5907511025162978499L;
	private String idMatriz = null;
	private String cabecera = null;
	private String validacion = "";
	private ArrayList<ArrayList<String>> valoresArr = new ArrayList<ArrayList<String>>();
	private String valores = null;
	private Boolean autoIniciar = true;
	private Integer numFilaScroll = null;
	private String anchuraCeldas = null;
	private String estiloCeldas = null;
	private String alturaFila = null;
	private String estilo = null;
	private Boolean soloLectura = false;
	private String clase = null;

	public int doStartTag() throws JspException {
		try {
			DatosSesionBean datosSesion = (DatosSesionBean) pageContext.getSession().getAttribute(WebKeys.DATOS_SESION);
			Translation t = datosSesion.getTranslation();

			//Se convierten los valores String a Array
			ArrayList<String> titCabecera = new ArrayList<String>(Arrays.asList(cabecera.split(",")));
			ArrayList<String> celdasAnch = new ArrayList<String>();
			if (anchuraCeldas != null) {
				celdasAnch = new ArrayList<String>(Arrays.asList(anchuraCeldas.split(",")));
				if (titCabecera.size() != celdasAnch.size()) {
					throw new JspTagException("El número de elementos en la cabecera(" + titCabecera.size() + ") no coincide con el de la anchura de celdas(" + celdasAnch.size() + ")");
				}
			}
			ArrayList<String> celdasEstilo = new ArrayList<String>();
			if (estiloCeldas != null) {
				celdasEstilo = new ArrayList<String>(Arrays.asList(estiloCeldas.split(",")));
				if (titCabecera.size() != celdasEstilo.size()) {
					throw new JspTagException("El número de elementos en la cabecera(" + titCabecera.size() + ") no coincide con el de estilo de celdas(" + celdasEstilo.size() + ")");
				}
			}
			valoresArr = new ArrayList<ArrayList<String>>();
			if (valores != null && !valores.isEmpty() && !valores.equals("[]")) {
				String regex = "\\[\\[|\\], \\[|\\]\\]";
				String[] filas = valores.split(regex);
				for (String str : filas) {
					ArrayList<String> nuevaFil = new ArrayList<String>();
					if (!str.isEmpty()) {
						String[] col = str.split(", ",-1);
						if (col.length != titCabecera.size()) {
							throw new JspTagException("Error parseando los valores a la matriz. El número de elementos en la cabecera(" + titCabecera.size() + ") no coincide con el de la fila("
							        + col.length + ")");
						}
						for (String s : col) {
							if (s.equals("null") || s.equals(" ")) {
								nuevaFil.add("");
							}
							else {
								nuevaFil.add(s);
							}
						}
						valoresArr.add(nuevaFil);
					}
				}
			}

			JspWriter out = pageContext.getOut();

			out.println("<div>");
			// ===================== SCRIPT ===================== 
			String scripts = "<script type=\"text/javascript\">";

			// FUNCION: evaluaLinea(input): Ejecuta la lógica de actualización de input. Si existe un método de valodación, lo llama antes.
			scripts += "function evaluaLinea(input,customCheck=true){" + "compruebaFilaActual(input);";
			if (!validacion.isEmpty()) {
				scripts += "if(" + validacion + "(input)){";
			}
			scripts+="actualizaMatriz(input)";

			if (!validacion.isEmpty()) {
				scripts += "}";
			}
			scripts += "}";
			
			// FUNCION: actualizarMatriz(input): Actualiza la matriz con el valor del input recibido
			scripts += "function actualizaMatriz(input){"
					+ "var trs =jQuery(\".tablaDinamica tbody\").find(\"tr\");" 
					+ "var inputs = jQuery(input).closest(\"tr\").find(\"input\");"
			        + "var indexX = trs.index(jQuery(input).closest(\"tr\"));" 
					+ "var indexY = inputs.index(jQuery(input));" + "var matriz = JSON.parse(jQuery(\"input#" + idMatriz + "\").val());"
			        + "if(matriz[indexX]==null){" 
					+ "		matriz[indexX]=[];" 
			        + "}matriz[indexX][indexY]=jQuery(input).val();" 
					+ "jQuery(\"input#" + idMatriz + "\").val(JSON.stringify(matriz))}";

			// FUNCION: compruebaFilaActual(input): Recibe un input y comprueba si su linea queda vacía, en cuyo caso la borra de la tabla (y la matriz)
			scripts += "function compruebaFilaActual(input){" 
					+ "var vacio = true;" 
					+ "jQuery(input).closest(\"tr\").find(\"input\").each(function(e,inp){" 
					+ "	if(jQuery(inp).val()!=\"\"){"
			        + " vacio=false;" 
					+ "	return false;" 
			        + "}});" 
					+ "if(vacio && jQuery(\".tablaDinamica\").find(\"tr\").length>2){" 
			        + "borrarLinea(input);" 
					+ "}}";

			// FUNCION: nuevaFila(data): Añade una nueva fila a la tabla (y a la matriz). Si no recibe datos crea la fila con valores vacíos
			scripts += "function nuevaFila(data){" 
					+ "var vacio = false;" 
					+ "if(data==null){" 
					+ "		data = [\"\",\"\",\"\"];" 
					+ "		vacio = true;" + "}"
			        + "jQuery(\".tablaDinamica tbody\").append(\"<tr>";
			int i;
			for (i = 0; i < titCabecera.size(); i++) {
				scripts += "<td><input type='text' class='campo";
				if (soloLectura) {
					scripts += " soloLectura' readonly='readonly'";
				}
				else {
					scripts += "'";
				}
				scripts += " id='col" + i + "' name='col" + i + "' maxlength='6' value='\"+data[" + i + "]+\"' style='";
				if (!celdasAnch.isEmpty()) {
					scripts += "width:" + celdasAnch.get(i) + ";";
				}
				if (alturaFila != null && !alturaFila.isEmpty()) {
					scripts += "height:" + alturaFila + ";";
				}
				if(!celdasEstilo.isEmpty()){
					scripts += celdasEstilo.get(i);
				}
				scripts += "'></td>";
			}
			scripts += "</tr>\");" 
					+ "var rows = jQuery(\".tablaDinamica tr\");" 
					+ "var matriz = JSON.parse(jQuery(\"input#" + idMatriz + "\").val());" 
					+ "matriz[rows.length-2]=[];"
			        + "rows.last().find(\"input\").each(function (index) {" 
					+ "	var inputI = jQuery(this).change(function(){" 
			        + "		evaluaLinea($(this));" 
					+ "	}).keydown(function (e) {"
			        + "var inputs = jQuery(\".tablaDinamica tbody\").find(\"input\");" 
					+ "if (!" + soloLectura + " && e.which === 8 && e.ctrlKey) {"
			        + "		var trs = jQuery(\".tablaDinamica tbody tr\");" 
					+ "		if(trs.length>1){" 
			        + "		if(e.preventDefault) {" 
					+ "			e.preventDefault();" 
			        + "		}" 
					+ "		borrarLinea(this);"
			        + "		return false;" 
					+ "}}if (!" + soloLectura + " && e.which === 9 && !e.shiftKey) {" 
			        + "		if(inputs.index(jQuery(this))+1==inputs.length){" 
					+ "		nuevaFila();" 
			        + "}}});"
			        + "if(vacio){" 
			        + "	matriz[rows.length-2][index]=\"\";" 
			        + "	jQuery(\"input#" + idMatriz + "\").val(JSON.stringify(matriz));" 
			        + "}});";

			scripts += "if(rows.length==2){" 
					+ "	var table = jQuery('.tablaDinamica');" 
					+ "	var bodyCells = table.find('tbody tr:first').find(\"input\");" 
					+ "	var colWidth = bodyCells.map(function() {"
			        + "    return jQuery(this).width();}).get();" 
			        + "	table.find('thead tr').children().each(function(i, v) {" 
			        + "    jQuery(v).width(colWidth[i]);});";

			if (numFilaScroll != null && numFilaScroll > 0) {
				scripts += "var colHeight = bodyCells.map(function() {" 
						+ "		return jQuery(this).height();}).get();"
				        + "var style= table.find('tbody').attr(\"style\")+\"max-height:\"+colHeight[0]*" + numFilaScroll + "+\"px;\";" + "table.find('tbody').attr(\"style\",style);";
			}
			scripts += "}}";

			// FUNCION: cargaValoresIniciales(): Carga los valores iniciales de la tabla si los hubiera
			scripts += "function cargaValoresIniciales(){";
			if (valoresArr != null && !valoresArr.isEmpty()) {
				for (ArrayList<String> str : valoresArr) {
					scripts += "nuevaFila([";
					for (String valor : str) {
						scripts += "\"" + valor + "\",";
					}
					scripts += "]);";
				}
			}
			scripts += "	}";

			// FUNCION: borrarLinea(input): Recibe un input y borra su linea de la tabla y la matriz
			scripts += "function borrarLinea(input){" 
					+ "		var matriz = JSON.parse(jQuery(\"input#" + idMatriz + "\").val());" 
					+ "		var trs =jQuery(\".tablaDinamica tbody\").find(\"tr\");"
			        + "		var indexX = trs.index(jQuery(input).closest(\"tr\"));" 
					+ "		matriz.splice(indexX,1);" 
			        + "		jQuery(\"input#" + idMatriz + "\").val(JSON.stringify(matriz));"
			        + "		jQuery(input).closest(\"tr\").prev().find(\"input\").last().focus();" 
			        + "		jQuery(input).closest(\"tr\").remove();}";

			// CARGA VALORES INICIALES
			if (autoIniciar) {
				scripts += "window.onload = function () { ";
				if(valoresArr !=null && !valoresArr.isEmpty()){
					scripts+= "cargaValoresIniciales();";
				}else{
					scripts+= "nuevaFila();";
					
				}
				//Busca si existe una función de inicio y la llama ya que window.onload lo sobreescribe
				scripts += "if(window.inicio){"
						+ "inicio();"
						+ "}"
						+ "else if(window.inicioForm){"
						+ "inicioForm();"
						+ "}}";
			}
			scripts += "</script>";

			out.print(scripts);;

			// ===================== TABLA ===================== 

			String tabla = "<table cellpadding='0' cellspacing='0' border='0' class='tablaDinamica ";

			if (clase != null && !clase.isEmpty()) {
				tabla += clase + "'";
			}
			else {
				tabla += "'";
			}

			// TABLA: ESTILO
			String style = " style='";
			if (estilo != null && !estilo.isEmpty()) {
				style += estilo;
			}
			style += "'";
			tabla += style;
			tabla += ">";

			tabla += "<input id=\"" + idMatriz + "\" name=\"" + idMatriz + "\" type=\"hidden\" value='" + getValoresFormateados() + "' />";
			// TABLA: CABECERA
			String cabeceraTabla = "<thead style=\"display:block\"><tr>";
			for (String titulo : titCabecera) {
				cabeceraTabla += "<th>" + t._(titulo) + "</th>";
			}
			cabeceraTabla += "</tr></thead>";
			tabla += cabeceraTabla;
			tabla += "<tbody style=\"display:block;overflow-y:auto;\">";

			out.println(tabla);

			return SKIP_BODY;
		}
		catch (Exception ex) {
			throw new JspTagException("doStartTag() - Excepción en la clase del tag TablaDinamica: " + ex.getMessage());
		}
	}

	public int doEndTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			out.println("</tbody>");
			out.println("</table>");
			out.println("</div>");
		}
		catch (Exception e) {
			throw new JspTagException("doEndTag() - Excepción en la clase del tag TablaDinamica: " + e.getMessage());
		}
		return SKIP_BODY;
	}

	public String getCabecera() {
		return cabecera;
	}

	public void setCabecera(String cabecera) {
		this.cabecera = cabecera;
	}

	public Integer getNumFilaScroll() {
		return numFilaScroll;
	}

	public void setNumFilaScroll(Integer numFilaScroll) {
		this.numFilaScroll = numFilaScroll;
	}

	public String getAnchuraCeldas() {
		return anchuraCeldas;
	}

	public void setAnchuraCeldas(String anchuraCeldas) {
		this.anchuraCeldas = anchuraCeldas;
	}

	public String getAlturaFila() {
		return alturaFila;
	}

	public void setAlturaFila(String alturaFila) {
		this.alturaFila = alturaFila;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public boolean isAutoIniciar() {
		return autoIniciar;
	}

	public void setAutoIniciar(boolean autoIniciar) {
		this.autoIniciar = autoIniciar;
	}

	public String getValidacion() {
		return validacion;
	}

	public void setValidacion(String validacion) {
		this.validacion = validacion;
	}

	public Boolean getAutoIniciar() {
		return autoIniciar;
	}

	public void setAutoIniciar(Boolean autoIniciar) {
		this.autoIniciar = autoIniciar;
	}

	public String getIdMatriz() {
		return idMatriz;
	}

	public void setIdMatriz(String idMatriz) {
		this.idMatriz = idMatriz;
	}

	public String getValoresFormateados() {
		String res = "[";
		int i = 1;
		if (valoresArr != null) {
			for (ArrayList<String> str : valoresArr) {
				res += "[";
				int j = 1;
				for (String valor : str) {
					res += "\"" + valor + "\"";
					if (str.size() > j) {
						res += ",";
					}
					j++;
				}
				res += "]";
				if (valoresArr.size() > i) {
					res += ",";
				}
				i++;
			}
		}
		res += "]";
		return res;
	}

	public Boolean getSoloLectura() {
		return soloLectura;
	}

	public void setSoloLectura(Boolean soloLectura) {
		this.soloLectura = soloLectura;
	}

	public ArrayList<ArrayList<String>> getValoresArr() {
		return valoresArr;
	}

	public void setValoresArr(ArrayList<ArrayList<String>> valoresArr) {
		this.valoresArr = valoresArr;
	}

	public String getValores() {
		return valores;
	}

	public void setValores(String valores) {
		this.valores = valores;
	}

	public String getEstiloCeldas() {
		return estiloCeldas;
	}

	public void setEstiloCeldas(String estiloCeldas) {
		this.estiloCeldas = estiloCeldas;
	}
	
}

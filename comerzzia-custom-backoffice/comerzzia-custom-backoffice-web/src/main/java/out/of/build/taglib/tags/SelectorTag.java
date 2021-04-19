package com.comerzzia.taglib.tags;

import java.util.Collections;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class SelectorTag extends BodyTagSupport{

	private static final long serialVersionUID = 4578780006862605940L;
	
	private List<String> valoresDisponibles = null;
	private List<String> seleccionados = null;
	private String idSelector = null;
	private String clase = null;
	private String altura = null;
	private String idOperador = null;
	
	public int doStartTag() throws JspException {
		id = idSelector;
		return EVAL_BODY_BUFFERED;
	}

	public int doEndTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			if(clase == null){
				clase = "campo";
			}
			String style = "style=\" min-width:100px;";
			if(altura != null && !altura.isEmpty()){
				style += "height:"+altura+";";
			}else{
				style += "height:150px;";
			}
			style += "\"";
			
			String input =  "<script type=\"text/javascript\" language=\"javascript\">								\n"+
							"function mover"+idSelector+"(fromObj, toObj){                                        	\n"+
							"	for (var selIndex = fromObj.length - 1; selIndex >= 0; selIndex--)					\n"+
							"	{																  					\n"+
							"      if (fromObj.options[selIndex].selected)											\n"+
							"     {																					\n"+
							"        var newText  = fromObj.options[selIndex].text;									\n"+
							"        var newValue = fromObj.options[selIndex].value;								\n"+
							"        var newOption = new Option(newText, newValue, true, true);						\n"+
							"        toObj[toObj.length] = newOption;												\n"+
							"																						\n"+
							"        fromObj[selIndex] = null;														\n"+
							"     }																					\n"+
							"	}																					\n"+	
							"	actualizarFiltros"+idSelector+"();													\n"+
							"}																						\n"+
							"function moverTodos"+idSelector+"(fromObj, toObj){                                     \n"+
							"	for (var selIndex = fromObj.length - 1; selIndex >= 0; selIndex--)					\n"+
							"	{																  					\n"+
							"        var newText  = fromObj.options[selIndex].text;									\n"+
							"        var newValue = fromObj.options[selIndex].value;								\n"+
							"        var newOption = new Option(newText, newValue, true, true);						\n"+
							"        toObj[toObj.length] = newOption;												\n"+
							"																						\n"+
							"        fromObj[selIndex] = null;														\n"+
							"	}																					\n"+	
							"	actualizarFiltros"+idSelector+"();													\n"+
							"}																						\n"+
							"function actualizarFiltros"+idSelector+"(){											\n"+
							"	var filtros = document.getElementById('"+idSelector+"');							\n"+
							"	var lengthFiltros = filtros.options.length;											\n"+
							"	var seleccionados = document.getElementById('seleccionados"+idSelector+"');			\n"+
							"	var lengthSeleccionados = seleccionados.options.length;								\n"+
							"	var disponibles = document.getElementById('disponibles"+idSelector+"');				\n"+
							"	sortOptions"+idSelector+"(disponibles)												\n"+
							"	sortOptions"+idSelector+"(seleccionados)											\n"+
							"	for (i = 0; i < lengthFiltros; i++) {												\n"+
							"		filtros.options[0] = null;														\n"+
							"	}																					\n"+
							"	for(i = 0; i<lengthSeleccionados;i++) {												\n"+
							"		var sel = seleccionados.options[i] 												\n"+
							"		var newOption = new Option(sel.text, sel.value, true, true);					\n"+
							"      	filtros.options[i] = newOption;													\n"+
							"	}  																					\n"+
							"}																						\n"+
							"function compareOptionText"+idSelector+"(a,b) {								 		\n"+
							"	  return a.text!=b.text ? a.text<b.text ? -1 : 1 : 0;								\n"+
							"}																						\n"+								 
							"function sortOptions"+idSelector+"(list) {												\n"+
							" 	var items = list.options.length;													\n"+
							" 	var tmpArray = new Array(items);													\n"+
							" 	for ( i=0; i<items; i++ )															\n"+
							"   tmpArray[i] = new Option(list.options[i].text,list.options[i].value, true, list.options[i].selected);\n"+
							"	tmpArray.sort(compareOptionText"+idSelector+");										\n"+
							"	for ( i=0; i<items; i++ )															\n"+
							"  	list.options[i] = new Option(tmpArray[i].text,tmpArray[i].value, true, tmpArray[i].selected);	\n"+							 
							"}																						\n"+
							"</script>																				\n";
			input +=        "<div style=\"display: inline-flex;\">																										"+
							"	<select id=\""+idSelector+"\" name=\""+idSelector+"\" style=\"display:none\" multiple></select>								"+			
							"	<div class=\"columna1\">																									"+
							"		<select id=\"disponibles"+idSelector+"\" class=\""+clase+"\" name=\"disponibles"+idSelector+"\" "+style+" multiple>";
			Collections.sort(valoresDisponibles);
			for(String opt : valoresDisponibles){
				input += 	"			<option value = \""+opt+"\">"+opt+"</option>";
			}

			input +=		"		</select> 																												"+
							"	</div>																														"+
							"	<div style=\"display: inline-grid; margin-left: 10px; margin-right: 10px\">													"+
							"		<div style=\"display: inline-grid;\">																					"+		
							"			<input name=\"btnAñadirTodos"+idSelector+"\" type=\"button\" style=\"margin-bottom: 2px; margin-top: 2px;\" class=\"boton\" value=\"&gt;&gt;\" onclick=\"moverTodos"+idSelector+"(disponibles"+idSelector+", seleccionados"+idSelector+");\"/> "+
							"			<input name=\"btnAñadir"+idSelector+"\" type=\"button\" style=\"margin-bottom: 2px; margin-top: 2px;\" class=\"boton\" value=\"&gt;\" onclick=\"mover"+idSelector+"(disponibles"+idSelector+", seleccionados"+idSelector+");\"/> "+
							"			<input name=\"btnBorrar"+idSelector+"\" type=\"button\" style=\"margin-bottom: 2px; margin-top: 2px;\" class=\"boton\" value=\"&lt;\" onclick=\"mover"+idSelector+"(seleccionados"+idSelector+", disponibles"+idSelector+");\"/> "+
							"			<input name=\"btnBorrarTodos"+idSelector+"\" type=\"button\" style=\"margin-bottom: 2px; margin-top: 2px;\" class=\"boton\" value=\"&lt;&lt;\" onclick=\"moverTodos"+idSelector+"(seleccionados"+idSelector+", disponibles"+idSelector+");\"/> "+
							"		</div>																													"+
							"		<div>																													"+
							"			<input type=\"radio\" name=\""+idOperador+"\" value=\"and\" checked> AND</input> 									"+
							"  			<input type=\"radio\" name=\""+idOperador+"\" value=\"or\"> OR</input> 												"+
							"		</div>																													"+
							"	</div>																														"+
							"	<div class=\"columna3\">																									"+
							"		<select id=\"seleccionados"+idSelector+"\" class=\""+clase+"\" name=\"seleccionados"+idSelector+"\" "+style+"multiple > ";
			if(seleccionados != null){
				for(String res : seleccionados){
					input += "			<option value = \""+res+"\">"+res+"</option>";
				}
			}
			
			input += 		"		</select>"+
							"	</div>"+
							"</div>";
			out.println(input);
			
			return SKIP_BODY;
		}
		catch (Exception ex){
			throw new JspTagException("Excepción en la clase del tag SelectorTag: "+ex.getMessage());
		}
	}
	
	public List<String> getValoresDisponibles() {
		return valoresDisponibles;
	}
	
	public void setValoresDisponibles(List<String> valoresDisponibles) {
		this.valoresDisponibles= valoresDisponibles;
	}

	public List<String> getSeleccionados() {
		return seleccionados;
	}

	public void setSeleccionados(List<String> seleccionados) {
		this.seleccionados = seleccionados;
	}

	public String getIdSelector() {
		return idSelector;
	}

	public void setIdSelector(String idSelector) {
		this.idSelector = idSelector;
	}
	
	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}
	
	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}
	
	public String getIdOperador() {
		return idOperador;
	}

	public void setIdOperador(String idOperador) {
		this.idOperador = idOperador;
	}
	
}

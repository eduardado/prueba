package com.comerzzia.api.core.web.util;

/*
 * Copyright (C) 2012 Neo Visionaries Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import java.util.HashMap;
import java.util.Map;


public enum CountryCode
{
    // @formatter:off
    /** <a href="http://en.wikipedia.org/wiki/Andorra">Andorra</a> */
	Andorra("AD", "AND", 16),

    /** <a href="http://en.wikipedia.org/wiki/United_Arab_Emirates">United Arab Emirates</a> */
    United_Arab_Emirates("AE", "ARE", 784),

    /** <a href="http://en.wikipedia.org/wiki/Afghanistan">Afghanistan</a> */
    Afghanistan("AF", "AFG", 4),

    /** <a href="http://en.wikipedia.org/wiki/Antigua_and_Barbuda">Antigua and Barbuda</a> */
    Antigua_and_Barbuda("AG", "ATG", 28),

    /** <a href="http://en.wikipedia.org/wiki/Anguilla">Anguilla</a> */
    Anguilla("AI", "AIA", 660),

    /** <a href="http://en.wikipedia.org/wiki/Albania">Albania</a> */
    Albania("AL", "ALB", 8),

    /** <a href="http://en.wikipedia.org/wiki/Armenia">Armenia</a> */
    Armenia("AM", "ARM", 51),

    /** <a href="http://en.wikipedia.org/wiki/Netherlands_Antilles">Netherlands Antilles</a> */
    Netherlands_Antilles("AN", "ANT", 530),

    /** <a href="http://en.wikipedia.org/wiki/Angola">Angola</a> */
    Angola("AO", "AGO", 24),

    /** <a href="http://en.wikipedia.org/wiki/Antarctica">Antarctica</a> */
    Antarctica("AQ", "ATA", 10),

    /** <a href="http://en.wikipedia.org/wiki/Argentina">Argentina</a> */
    Argentina("AR", "ARG", 32),

    /** <a href="http://en.wikipedia.org/wiki/American_Samoa">American Samoa</a> */
    American_Samoa("AS", "ASM", 16),

    /** <a href="http://en.wikipedia.org/wiki/Austria">Austria</a> */
    Austria("AT", "AUT", 40),

    /** <a href="http://en.wikipedia.org/wiki/Australia">Australia</a> */
    Australia("AU", "AUS", 36),

    /** <a href="http://en.wikipedia.org/wiki/Aruba">Aruba</a> */
    Aruba("AW", "ABW", 533),

    /** <a href="http://en.wikipedia.org/wiki/%C3%85land_Islands">&Aring;land Islands</a> */
    Bland_Islands("AX", "ALA", 248),

    /** <a href="http://en.wikipedia.org/wiki/Azerbaijan">Azerbaijan</a> */
    Azerbaijan("AZ", "AZE", 31),

    /** <a href="http://en.wikipedia.org/wiki/Bosnia_and_Herzegovina">Bosnia and Herzegovina</a> */
    Bosnia_and_Herzegovina("BA", "BIH", 70),

    /** <a href="http://en.wikipedia.org/wiki/Barbados">Barbados</a> */
    Barbados("BB", "BRB", 52),

    /** <a href="http://en.wikipedia.org/wiki/Bangladesh">Bangladesh</a> */
    Bangladesh("BD", "BGD", 50),

    /** <a href="http://en.wikipedia.org/wiki/Belgium">Belgium</a> */
    Belgium("BE", "BEL", 56),

    /** <a href="http://en.wikipedia.org/wiki/Burkina_Faso">Burkina Faso</a> */
    Burkina_Faso("BF", "BFA", 854),

    /** <a href="http://en.wikipedia.org/wiki/Bulgaria">Bulgaria</a> */
    Bulgaria("BG", "BGR", 100),

    /** <a href="http://en.wikipedia.org/wiki/Bahrain">Bahrain</a> */
    Bahrain("BH", "BHR", 48),

    /** <a href="http://en.wikipedia.org/wiki/Burundi">Burundi</a> */
    Burundi("BI", "BDI", 108),

    /** <a href="http://en.wikipedia.org/wiki/Benin">Benin</a> */
    Benin("BJ", "BEN", 204),

    /** <a href="http://en.wikipedia.org/wiki/Saint_Barth%C3%A9lemy">Saint Barth&eacute;lemy</a> */
   Saint_Barthelemy ("BL", "BLM", 652),

    /** <a href="http://en.wikipedia.org/wiki/Bermuda">Bermuda</a> */
    Bermuda("BM", "BMU", 60),

    /** <a href="http://en.wikipedia.org/wiki/Brunei">Brunei Darussalam</a> */
    Brunei_Darussalam("BN", "BRN", 96),

    /** <a href="http://en.wikipedia.org/wiki/Bolivia">Plurinational State of Bolivia</a> */
    Plurinational_State_of_Bolivia("BO", "BOL", 68),

    /** <a href="http://en.wikipedia.org/wiki/Caribbean_Netherlands">Bonaire, Sint Eustatius and Saba</a> */
    Caribbean_Netherlands ("BQ", "BES", 535),

    /** <a href="http://en.wikipedia.org/wiki/Brazil">Brazil</a> */
    Brazil("BR", "BRA", 76),

    /** <a href="http://en.wikipedia.org/wiki/The_Bahamas">Bahamas</a> */
    Bahamas("BS", "BHS", 44),

    /** <a href="http://en.wikipedia.org/wiki/Bhutan">Bhutan</a> */
    Bhutan("BT", "BTN", 64),

    /** <a href="http://en.wikipedia.org/wiki/Bouvet_Island">Bouvet Island</a> */
    Bouvet_Island("BV", "BVT", 74),

    /** <a href="http://en.wikipedia.org/wiki/Botswana">Botswana</a> */
    Botswana("BW", "BWA", 72),

    /** <a href="http://en.wikipedia.org/wiki/Belarus">Belarus</a> */
    Belarus("BY", "BLR", 112),

    /** <a href="http://en.wikipedia.org/wiki/Belize">Belize</a> */
    Belize("BZ", "BLZ", 84),

    /** <a href="http://en.wikipedia.org/wiki/Canada">Canada</a> */
    Canada("CA", "CAN", 124),

    /** <a href="http://en.wikipedia.org/wiki/Cocos_(Keeling)_Islands">Cocos (Keeling) Islands</a> */
    Cocos_Islands("CC", "CCK", 166),

    /** <a href="http://en.wikipedia.org/wiki/Democratic_Republic_of_the_Congo">The Democratic Republic of the Congo</a> */
    The_Democratic_Republic_of_the_Congo("CD", "COD", 180),

    /** <a href="http://en.wikipedia.org/wiki/Central_African_Republic">Central African Republic</a> */
    Central_African_Republic("CF", "CAF", 140),

    /** <a href="http://en.wikipedia.org/wiki/Republic_of_the_Congo">Congo</a> */
    Congo("CG", "COG", 178),

    /** <a href="http://en.wikipedia.org/wiki/Switzerland">Switzerland</a> */
    Switzerland("CH", "CHE", 756),

    /** <a href="http://en.wikipedia.org/wiki/C%C3%B4te_d%27Ivoire">C&ocirc;te d'Ivoire</a> */
    Ivory_Coast("CI", "CIV", 384),

    /** <a href="http://en.wikipedia.org/wiki/Cook_Islands">Cook Islands</a> */
    Cook_Islands("CK", "COK", 184),

    /** <a href="http://en.wikipedia.org/wiki/Chile">Chile</a> */
    Chile("CL", "CHL", 152),

    /** <a href="http://en.wikipedia.org/wiki/Cameroon">Cameroon</a> */
    Cameroon("CM", "CMR", 120),

    /** <a href="http://en.wikipedia.org/wiki/China">China</a> */
    China("CN", "CHN", 156),

    /** <a href="http://en.wikipedia.org/wiki/Colombia">Colombia</a> */
    Colombia("CO", "COL", 170),

    /** <a href="http://en.wikipedia.org/wiki/Costa_Rica">Costa Rica</a> */
    Costa_Rica("CR", "CRI", 188),

    /** <a href="http://en.wikipedia.org/wiki/Cuba">Cuba</a> */
    Cuba("CU", "CUB", 192),

    /** <a href="http://en.wikipedia.org/wiki/Cape_Verde">Cape Verde</a> */
    Cape_Verde("CV", "CPV", 132),

    /** <a href="http://en.wikipedia.org/wiki/Cura%C3%A7ao">Cura&ccedil;ao</a> */
    Curaçao("CW", "CUW", 531),

    /** <a href="http://en.wikipedia.org/wiki/Christmas_Island">Christmas Island</a> */
    Christmas_Island("CX", "CXR", 162),

    /** <a href="http://en.wikipedia.org/wiki/Cyprus">Cyprus</a> */
    Cyprus("CY", "CYP", 196),

    /** <a href="http://en.wikipedia.org/wiki/Czech_Republic">Czech Republic</a> */
    Czech_Republic("CZ", "CZE", 203),

    /** <a href="http://en.wikipedia.org/wiki/Germany">Germany</a> */
    Germany("DE", "DEU", 276),

    /** <a href="http://en.wikipedia.org/wiki/Djibouti">Djibouti </a> */
    Djibouti("DJ", "DJI", 262),

    /** <a href="http://en.wikipedia.org/wiki/Denmark">Denmark</a> */
    Denmark("DK", "DNK", 208),

    /** <a href="http://en.wikipedia.org/wiki/Dominica">Dominica</a> */
    Dominica("DM", "DMA", 212),

    /** <a href="http://en.wikipedia.org/wiki/Dominican_Republic">Dominican Republic</a> */
    Dominican_Republic("DO", "DOM", 214),

    /** <a href="http://en.wikipedia.org/wiki/Algeria">Algeria</a> */
    Algeria("DZ", "DZA", 12),

    /** <a href="http://en.wikipedia.org/wiki/Ecuador">Ecuador</a> */
    Ecuador("EC", "ECU", 218),

    /** <a href="http://en.wikipedia.org/wiki/Estonia">Estonia</a> */
    Estonia("EE", "EST", 233),

    /** <a href="http://en.wikipedia.org/wiki/Egypt">Egypt</a> */
    Egypt("EG", "EGY", 818),

    /** <a href="http://en.wikipedia.org/wiki/Western_Sahara">Western Sahara</a> */
    Western_Sahara("EH", "ESH", 732),

    /** <a href="http://en.wikipedia.org/wiki/Eritrea">Eritrea</a> */
    Eritrea("ER", "ERI", 232),

    /** <a href="http://en.wikipedia.org/wiki/Spain">Spain</a> */
    Spain("ES", "ESP", 724),

    /** <a href="http://en.wikipedia.org/wiki/Ethiopia">Ethiopia</a> */
    Ethiopia("ET", "ETH", 231),

    /** <a href="http://en.wikipedia.org/wiki/Finland">Finland</a> */
    Finland("FI", "FIN", 246),

    /** <a href="http://en.wikipedia.org/wiki/Fiji">Fiji</a> */
    Fiji("FJ", "FJI", 242),

    /** <a href="http://en.wikipedia.org/wiki/Falkland_Islands">Falkland Islands (Malvinas)</a> */
    Falkland_Islands("FK", "FLK", 238),

    /** <a href="http://en.wikipedia.org/wiki/Federated_States_of_Micronesia">Federated States of Micronesia</a> */
    Federated_States_of_Micronesia("FM", "FSM", 583),

    /** <a href="http://en.wikipedia.org/wiki/Faroe_Islands">Faroe Islands</a> */
    Faroe_Islands("FO", "FRO", 234),

    /** <a href="http://en.wikipedia.org/wiki/France">France</a> */
    France("FR", "FRA", 250),

    /** <a href="http://en.wikipedia.org/wiki/Gabon">Gabon </a> */
    Gabon("GA", "GAB", 266),

    /** <a href="http://en.wikipedia.org/wiki/United_Kingdom">United Kingdom</a> */
    United_Kingdom("GB", "GBR", 826),

    /** <a href="http://en.wikipedia.org/wiki/Grenada">Grenada</a> */
    Grenada("GD", "GRD", 308),

    /** <a href="http://en.wikipedia.org/wiki/Georgia_(country)">Georgia</a> */
    Georgia("GE", "GEO", 268),

    /** <a href="http://en.wikipedia.org/wiki/French_Guiana">French Guiana</a> */
    French Guiana("GF", "GUF", 254),

    /** <a href="http://en.wikipedia.org/wiki/Guernsey">Guemsey</a> */
    Guemsey("GG", "GGY", 831),

    /** <a href="http://en.wikipedia.org/wiki/Ghana">Ghana</a> */
    Ghana("GH", "GHA", 288),

    /** <a href="http://en.wikipedia.org/wiki/Gibraltar">Gibraltar</a> */
    Gibraltar("GI", "GIB", 292),

    /** <a href="http://en.wikipedia.org/wiki/Greenland">Greenland</a> */
    Greenland("GL", "GRL", 304),

    /** <a href="http://en.wikipedia.org/wiki/The_Gambia">Gambia</a> */
    Gambia("GM", "GMB", 270),

    /** <a href="http://en.wikipedia.org/wiki/Guinea">Guinea</a> */
    Guinea("GN", "GIN", 324),

    /** <a href="http://en.wikipedia.org/wiki/Guadeloupe">Guadeloupe</a> */
    Guadeloupe("GP", "GLP", 312),

    /** <a href="http://en.wikipedia.org/wiki/Equatorial_Guinea">Equatorial Guinea</a> */
    Equatorial_Guinea("GQ", "GNQ", 226),

    /** <a href="http://en.wikipedia.org/wiki/Greece">Greece</a> */
    Greece("GR", "GRC", 300),

    /** <a href="http://en.wikipedia.org/wiki/South_Georgia_and_the_South_Sandwich_Islands">South Georgia and the South Sandwich Islands</a> */
    South_Georgia_and_the_South_Sandwich_Islands("GS", "SGS", 239),

    /** <a href="http://en.wikipedia.org/wiki/Guatemala">Guatemala</a> */
    Guatemala("GT", "GTM", 320),

    /** <a href="http://en.wikipedia.org/wiki/Guam">Guam</a> */
    Guam("GU", "GUM", 316),

    /** <a href="http://en.wikipedia.org/wiki/Guinea-Bissau">Guinea-Bissau</a> */
    Guinea_Bissau("GW", "GNB", 624),

    /** <a href="http://en.wikipedia.org/wiki/Guyana">Guyana</a> */
    Guyana("GY", "GUY", 328),

    /** <a href="http://en.wikipedia.org/wiki/Hong_Kong">Hong Kong</a> */
    Hong_Kong("HK", "HKG", 344),

    /** <a href="http://en.wikipedia.org/wiki/Heard_Island_and_McDonald_Islands">Heard Island and McDonald Islands</a> */
    Heard_Island_and_McDonald_Islands("HM", "HMD", 334),

    /** <a href="http://en.wikipedia.org/wiki/Honduras">Honduras</a> */
    Honduras("HN", "HND", 340),

    /** <a href="http://en.wikipedia.org/wiki/Croatia">Croatia</a> */
    Croatia("HR", "HRV", 191),

    /** <a href="http://en.wikipedia.org/wiki/Haiti">Haiti</a> */
    Haiti("HT", "HTI", 332),

    /** <a href="http://en.wikipedia.org/wiki/Hungary">Hungary</a> */
    Hungary("HU", "HUN", 348),

    /** <a href="http://en.wikipedia.org/wiki/Indonesia">Indonesia</a> */
    Indonesia("ID", "IDN", 360),

    /** <a href="http://en.wikipedia.org/wiki/Republic_of_Ireland">Ireland</a> */
    Ireland("IE", "IRL", 372),

    /** <a href="http://en.wikipedia.org/wiki/Israel">Israel</a> */
    Israel("IL", "ISR", 376),

    /** <a href="http://en.wikipedia.org/wiki/Isle_of_Man">Isle of Man</a> */
    Isle_of_Man("IM", "IMN", 833),

    /** <a href="http://en.wikipedia.org/wiki/India">India</a> */
    India("IN", "IND", 356),

    /** <a href="http://en.wikipedia.org/wiki/British_Indian_Ocean_Territory">British Indian Ocean Territory</a> */
    British_Indian_Ocean_Territory("IO", "IOT", 86),

    /** <a href="http://en.wikipedia.org/wiki/Iraq">Iraq</a> */
    Iraq("IQ", "IRQ", 368),

    /** <a href="http://en.wikipedia.org/wiki/Iran">Islamic Republic of Iran</a> */
    Islamic_Republic_of_Iran("IR", "IRN", 364),

    /** <a href="http://en.wikipedia.org/wiki/Iceland">Iceland</a> */
    Iceland("IS", "ISL", 352),

    /** <a href="http://en.wikipedia.org/wiki/Italy">Italy</a> */
    Italy("IT", "ITA", 380),

    /** <a href="http://en.wikipedia.org/wiki/Jersey">Jersey</a> */
    Jersey("JE", "JEY", 832),

    /** <a href="http://en.wikipedia.org/wiki/Jamaica">Jamaica</a> */
    Jamaica("JM", "JAM", 388),

    /** <a href="http://en.wikipedia.org/wiki/Jordan">Jordan</a> */
    Jordan("JO", "JOR", 400),

    /** <a href="http://en.wikipedia.org/wiki/Japan">Japan</a> */
    Japan("JP", "JPN", 392),

    /** <a href="http://en.wikipedia.org/wiki/Kenya">Kenya</a> */
    Kenya("KE", "KEN", 404),

    /** <a href="http://en.wikipedia.org/wiki/Kyrgyzstan">Kyrgyzstan</a> */
    Kyrgyzstan("KG", "KGZ", 417),

    /** <a href="http://en.wikipedia.org/wiki/Cambodia">Cambodia</a> */
    Cambodia("KH", "KHM", 116),

    /** <a href="http://en.wikipedia.org/wiki/Kiribati">Kiribati</a> */
    Kiribati("KI", "KIR", 296),

    /** <a href="http://en.wikipedia.org/wiki/Comoros">Comoros</a> */
    Comoros("KM", "COM", 174),

    /** <a href="http://en.wikipedia.org/wiki/Saint_Kitts_and_Nevis">Saint Kitts and Nevis</a> */
    Saint_Kitts_and_Nevis("KN", "KNA", 659),

    /** <a href="http://en.wikipedia.org/wiki/North_Korea">Democratic People's Republic of Korea</a> */
    Democratic_People's_Republic_of_Korea("KP", "PRK", 408),

    /** <a href="http://en.wikipedia.org/wiki/South_Korea">Republic of Korea</a> */
    Republic_of_Korea("KR", "KOR", 410),

    /** <a href="http://en.wikipedia.org/wiki/Kuwait">Kuwait</a> */
    Kuwait("KW", "KWT", 414),

    /** <a href="http://en.wikipedia.org/wiki/Cayman_Islands">Cayman Islands</a> */
    Cayman_Islands("KY", "CYM", 136),

    /** <a href="http://en.wikipedia.org/wiki/Kazakhstan">Kazakhstan</a> */
    Kazakhstan("KZ", "KAZ", 398),

    /** <a href="http://en.wikipedia.org/wiki/Laos">Lao People's Democratic Republic</a> */
    Laos("LA", "LAO", 418),

    /** <a href="http://en.wikipedia.org/wiki/Lebanon">Lebanon</a> */
    Lebanon("LB", "LBN", 422),

    /** <a href="http://en.wikipedia.org/wiki/Saint_Lucia">Saint Lucia</a> */
    Saint_Lucia("LC", "LCA", 662),

    /** <a href="http://en.wikipedia.org/wiki/Liechtenstein">Liechtenstein</a> */
    Liechtenstein("LI", "LIE", 438),

    /** <a href="http://en.wikipedia.org/wiki/Sri_Lanka">Sri Lanka</a> */
    Sri_Lanka("LK", "LKA", 144),

    /** <a href="http://en.wikipedia.org/wiki/Liberia">Liberia</a> */
    Liberia("LR", "LBR", 430),

    /** <a href="http://en.wikipedia.org/wiki/Lesotho">Lesotho</a> */
    Lesotho("LS", "LSO", 426),

    /** <a href="http://en.wikipedia.org/wiki/Lithuania">Lithuania</a> */
    Lithuania("LT", "LTU", 440),

    /** <a href="http://en.wikipedia.org/wiki/Luxembourg">Luxembourg</a> */
    Luxembourg("LU", "LUX", 442),

    /** <a href="http://en.wikipedia.org/wiki/Latvia">Latvia</a> */
    Latvia("LV", "LVA", 428),

    /** <a href="http://en.wikipedia.org/wiki/Libya">Libya</a> */
    Libya("LY", "LBY", 434),

    /** <a href="http://en.wikipedia.org/wiki/Morocco">Morocco</a> */
    Morocco("MA", "MAR", 504),

    /** <a href="http://en.wikipedia.org/wiki/Monaco">Monaco</a> */
    Monaco("MC", "MCO", 492),

    /** <a href="http://en.wikipedia.org/wiki/Moldova">Republic of Moldova</a> */
    Republic_of_Moldova("MD", "MDA", 498),

    /** <a href="http://en.wikipedia.org/wiki/Montenegro">Montenegro</a> */
    Montenegro("ME", "MNE", 499),

    /** <a href="http://en.wikipedia.org/wiki/Collectivity_of_Saint_Martin">Saint Martin (French part)</a> */
    Saint Martin("MF", "MAF", 663),

    /** <a href="http://en.wikipedia.org/wiki/Madagascar">Madagascar</a> */
    Madagascar("MG", "MDG",450),

    /** <a href="http://en.wikipedia.org/wiki/Marshall_Islands">Marshall Islands</a> */
    Marshall_Islands("MH", "MHL", 584),

    /** <a href="http://en.wikipedia.org/wiki/Republic_of_Macedonia">The former Yugoslav Republic of Macedonia</a> */
    North_Macedonia("MK", "MKD", 807),

    /** <a href="http://en.wikipedia.org/wiki/Mali">Mali</a> */
    Mali("ML", "MLI", 466),

    /** <a href="http://en.wikipedia.org/wiki/Myanmar">Myanmar</a> */
    Myanmar("MM", "MMR", 104),

    /** <a href="http://en.wikipedia.org/wiki/Mongolia">Mongolia</a> */
    Mongolia("MN", "MNG", 496),

    /** <a href="http://en.wikipedia.org/wiki/Macau">Macao</a> */
    Macao("MO", "MAC", 446),

    /** <a href="http://en.wikipedia.org/wiki/Northern_Mariana_Islands">Northern Mariana Islands</a> */
    Northern_Mariana_Islands("MP", "MNP",580),

    /** <a href="http://en.wikipedia.org/wiki/Martinique">Martinique</a> */
    Martinique("MQ", "MTQ", 474),

    /** <a href="http://en.wikipedia.org/wiki/Mauritania">Mauritania</a> */
    Mauritania("MR", "MRT", 478),

    /** <a href="http://en.wikipedia.org/wiki/Montserrat">Montserrat</a> */
    Montserrat("MS", "MSR", 500),

    /** <a href="http://en.wikipedia.org/wiki/Malta">Malta</a> */
    Malta("MT", "MLT", 470),

    /** <a href="http://en.wikipedia.org/wiki/Mauritius">Mauritius</a> */
    Mauritius("MU", "MUS", 480),

    /** <a href="http://en.wikipedia.org/wiki/Maldives">Maldives</a> */
    Maldives("MV", "MDV", 462),

    /** <a href="http://en.wikipedia.org/wiki/Malawi">Malawi</a> */
    Malawi("MW", "MWI", 454),

    /** <a href="http://en.wikipedia.org/wiki/Mexico">Mexico</a> */
    Mexico("MX", "MEX", 484),

    /** <a href="http://en.wikipedia.org/wiki/Malaysia">Malaysia</a> */
    Malaysia("MY", "MYS", 458),

    /** <a href="http://en.wikipedia.org/wiki/Mozambique">Mozambique</a> */
    Mozambique("MZ", "MOZ", 508),

    /** <a href="http://en.wikipedia.org/wiki/Namibia">Namibia</a> */
    Namibia("NA", "NAM", 516),

    /** <a href="http://en.wikipedia.org/wiki/New_Caledonia">New Caledonia</a> */
    New_Caledonia("NC", "NCL", 540),

    /** <a href="http://en.wikipedia.org/wiki/Niger">Niger</a> */
    Niger("NE", "NER", 562),

    /** <a href="http://en.wikipedia.org/wiki/Norfolk_Island">Norfolk Island</a> */
    Norfolk_Island("NF", "NFK", 574),

    /** <a href="http://en.wikipedia.org/wiki/Nigeria">Nigeria</a> */
    Nigeria("NG","NGA", 566),

    /** <a href="http://en.wikipedia.org/wiki/Nicaragua">Nicaragua</a> */
    Nicaragua("NI", "NIC", 558),

    /** <a href="http://en.wikipedia.org/wiki/Netherlands">Netherlands</a> */
    Netherlands("NL", "NLD", 528),

    /** <a href="http://en.wikipedia.org/wiki/Norway">Norway</a> */
    Norway("NO", "NOR", 578),

    /** <a href="http://en.wikipedia.org/wiki/Nepal">Nepal</a> */
    Nepal("NP", "NPL", 524),

    /** <a href="http://en.wikipedia.org/wiki/Nauru">Nauru</a> */
    Nauru("NR", "NRU", 520),

    /** <a href="http://en.wikipedia.org/wiki/Niue">Niue</a> */
    Niue("NU", "NIU", 570),

    /** <a href="http://en.wikipedia.org/wiki/New_Zealand">New Zealand</a> */
    New_Zealand("NZ", "NZL", 554),

    /** <a href=http://en.wikipedia.org/wiki/Oman"">Oman</a> */
    Oman("OM", "OMN", 512),

    /** <a href="http://en.wikipedia.org/wiki/Panama">Panama</a> */
    Panama("PA", "PAN", 591),

    /** <a href="http://en.wikipedia.org/wiki/Peru">Peru</a> */
    Peru("PE", "PER", 604),

    /** <a href="http://en.wikipedia.org/wiki/French_Polynesia">French Polynesia</a> */
    French_Polynesia("PF", "PYF", 258),

    /** <a href="http://en.wikipedia.org/wiki/Papua_New_Guinea">Papua New Guinea</a> */
    Papua_New_Guinea("PG", "PNG", 598),

    /** <a href="http://en.wikipedia.org/wiki/Philippines">Philippines</a> */
    Philippines("PH", "PHL", 608),

    /** <a href="http://en.wikipedia.org/wiki/Pakistan">Pakistan</a> */
    Pakistan("PK", "PAK", 586),

    /** <a href="http://en.wikipedia.org/wiki/Poland">Poland</a> */
    Poland("PL", "POL", 616),

    /** <a href="http://en.wikipedia.org/wiki/Saint_Pierre_and_Miquelon">Saint Pierre and Miquelon</a> */
    Saint_Pierre_and_Miquelon("PM", "SPM", 666),

    /** <a href="http://en.wikipedia.org/wiki/Pitcairn_Islands">Pitcairn</a> */
    Pitcairn("PN", "PCN", 612),

    /** <a href="http://en.wikipedia.org/wiki/Puerto_Rico">Puerto Rico</a> */
    Puerto Rico("PR", "PRI", 630),

    /** <a href="http://en.wikipedia.org/wiki/Palestinian_territories">Occupied Palestinian Territory</a> */
    Occupied_Palestinian_Territory("PS", "PSE", 275),

    /** <a href="http://en.wikipedia.org/wiki/Portugal">Portugal</a> */
    Portugal("PT", "PRT", 620),

    /** <a href="http://en.wikipedia.org/wiki/Palau">Palau</a> */
    Palau("PW", "PLW", 585),

    /** <a href="http://en.wikipedia.org/wiki/Paraguay">Paraguay</a> */
    Paraguay("PY", "PRY", 600),

    /** <a href="http://en.wikipedia.org/wiki/Qatar">Qatar</a> */
    Qatar("QA", "QAT", 634),

    /** <a href="http://en.wikipedia.org/wiki/R%C3%A9union">R&eacute;union</a> */
    Reunion("RE", "REU", 638),

    /** <a href="http://en.wikipedia.org/wiki/Romania">Romania</a> */
    Romania("RO", "ROU", 642),

    /** <a href="http://en.wikipedia.org/wiki/Serbia">Serbia</a> */
    Serbia("RS", "SRB", 688),

    /** <a href="http://en.wikipedia.org/wiki/Russia">Russian Federation</a> */
    Russia("RU", "RUS", 643),

    /** <a href="http://en.wikipedia.org/wiki/Rwanda">Rwanda</a> */
    Rwanda("RW", "RWA", 646),

    /** <a href="http://en.wikipedia.org/wiki/Saudi_Arabia">Saudi Arabia</a> */
    Saudi_Arabia("SA", "SAU", 682),

    /** <a href="http://en.wikipedia.org/wiki/Solomon_Islands">Solomon Islands</a> */
    Solomon_Islands("SB", "SLB", 90),

    /** <a href="http://en.wikipedia.org/wiki/Seychelles">Seychelles</a> */
    Seychelles("SC", "SYC", 690),

    /** <a href="http://en.wikipedia.org/wiki/Sudan">Sudan</a> */
    Sudan("SD", "SDN", 729),

    /** <a href="http://en.wikipedia.org/wiki/Sweden">Sweden</a> */
    Sweden("SE", "SWE", 752),

    /** <a href="http://en.wikipedia.org/wiki/Singapore">Singapore</a> */
    Singapore("SG", "SGP", 702),

    /** <a href="http://en.wikipedia.org/wiki/Saint_Helena,_Ascension_and_Tristan_da_Cunha">Saint Helena, Ascension and Tristan da Cunha</a> */
    Saint_Helena_Ascension_and_Tristan_da_Cunha("SH", "SHN", 654),

    /** <a href="http://en.wikipedia.org/wiki/Slovenia">Slovenia</a> */
    Slovenia("SI", "SVN", 705),

    /** <a href="http://en.wikipedia.org/wiki/Svalbard_and_Jan_Mayen">Svalbard and Jan Mayen</a> */
   _Svalbard_and_Jan_Mayen("SJ", "SJM", 744),

    /** <a href="http://en.wikipedia.org/wiki/Slovakia">Slovakia</a> */
    Slovakia("SK", "SVK", 703),

    /** <a href="http://en.wikipedia.org/wiki/Sierra_Leone">Sierra Leone</a> */
    Sierra_Leone("SL", "SLE", 694),

    /** <a href="http://en.wikipedia.org/wiki/San_Marino">San Marino</a> */
    San_Marino("SM", "SMR", 674),

    /** <a href="http://en.wikipedia.org/wiki/Senegal">Senegal</a> */
    Senegal("SN", "SEN", 686),

    /** <a href="http://en.wikipedia.org/wiki/Somalia">Somalia</a> */
    Somalia("SO", "SOM", 706),

    /** <a href="http://en.wikipedia.org/wiki/Suriname">Suriname</a> */
    Suriname("SR", "SUR", 740),

    /** <a href="http://en.wikipedia.org/wiki/South_Sudan">South Sudan</a> */
    South_Sudan("SS", "SSD", 728),

    /** <a href="http://en.wikipedia.org/wiki/S%C3%A3o_Tom%C3%A9_and_Pr%C3%ADncipe">Sao Tome and Principe</a> */
    Sao_Tome_and_Principe("ST", "STP", 678),

    /** <a href="http://en.wikipedia.org/wiki/El_Salvador">El Salvador</a> */
    El_Salvador("SV", "SLV", 222),

    /** <a href="http://en.wikipedia.org/wiki/Sint_Maarten">Sint Maarten (Dutch part)</a> */
    Sint_Maarten("SX", "SXM", 534),

    /** <a href="http://en.wikipedia.org/wiki/Syria">Syrian Arab Republic</a> */
   _Syrian_Arab_Republic("SY", "SYR", 760),

    /** <a href="http://en.wikipedia.org/wiki/Swaziland">Swaziland</a> */
    Swaziland("SZ", "SWZ", 748),

    /** <a href="http://en.wikipedia.org/wiki/Turks_and_Caicos_Islands">Turks and Caicos Islands</a> */
    Turks_and_Caicos_Islands("TC", "TCA", 796),

    /** <a href="http://en.wikipedia.org/wiki/Chad">Chad</a> */
    Chad("TD", "TCD", 148),

    /** <a href="http://en.wikipedia.org/wiki/French_Southern_and_Antarctic_Lands">French Southern Territories</a> */
    French_Southern_Territories("TF", "ATF", 260),

    /** <a href="http://en.wikipedia.org/wiki/Togo">Togo</a> */
    Togo("TG", "TGO", 768),

    /** <a href="http://en.wikipedia.org/wiki/Thailand">Thailand</a> */
    Thailand("TH", "THA", 764),

    /** <a href="http://en.wikipedia.org/wiki/Tajikistan">Tajikistan</a> */
    Tajikistan("TJ", "TJK", 762),

    /** <a href="http://en.wikipedia.org/wiki/Tokelau">Tokelau</a> */
    Tokelau("TK", "TKL", 772),

    /** <a href="http://en.wikipedia.org/wiki/East_Timor">Timor-Leste</a> */
    Timor_Leste("TL", "TLS", 626),

    /** <a href="http://en.wikipedia.org/wiki/Turkmenistan">Turkmenistan</a> */
    Turkmenistan("TM", "TKM", 795),

    /** <a href="http://en.wikipedia.org/wiki/Tunisia">Tunisia</a> */
    Tunisia("TN", "TUN", 788),

    /** <a href="http://en.wikipedia.org/wiki/Tonga">Tonga</a> */
    Tonga("TO", "TON", 776),

    /** <a href="http://en.wikipedia.org/wiki/Turkey">Turkey</a> */
    Turkey("TR", "TUR", 792),

    /** <a href="http://en.wikipedia.org/wiki/Trinidad_and_Tobago">Trinidad and Tobago</a> */
    Trinidad_and_Tobago("TT", "TTO", 780),

    /** <a href="http://en.wikipedia.org/wiki/Tuvalu">Tuvalu</a> */
    Tuvalu("TV", "TUV", 798),

    /** <a href="http://en.wikipedia.org/wiki/Taiwan">Taiwan, Province of China</a> */
    Taiwan("TW", "TWN", 158),

    /** <a href="http://en.wikipedia.org/wiki/Tanzania">United Republic of Tanzania</a> */
    Tanzania("TZ", "TZA", 834),

    /** <a href="http://en.wikipedia.org/wiki/Ukraine">Ukraine</a> */
    Ukraine("UA", "UKR", 804),

    /** <a href="http://en.wikipedia.org/wiki/Uganda">Uganda</a> */
    Uganda("UG", "UGA", 800),

    /** <a href="http://en.wikipedia.org/wiki/United_States_Minor_Outlying_Islands">United States Minor Outlying Islands</a> */
    United_States_Minor_Outlying_Islands("UM", "UMI", 581),

    /** <a href="http://en.wikipedia.org/wiki/United_States">United States</a> */
    United_States("US", "USA", 840),

    /** <a href="http://en.wikipedia.org/wiki/Uruguay">Uruguay</a> */
    Uruguay("UY", "URY", 858),

    /** <a href="http://en.wikipedia.org/wiki/Uzbekistan">Uzbekistan</a> */
    Uzbekistan("UZ", "UZB", 860),

    /** <a href="http://en.wikipedia.org/wiki/Vatican_City">Holy See (Vatican City State)</a> */
    Holy_See("VA", "VAT", 336),

    /** <a href="http://en.wikipedia.org/wiki/Saint_Vincent_and_the_Grenadines">Saint Vincent and the Grenadines</a> */
    Saint_Vincent_and_the_Grenadines("VC", "VCT", 670),

    /** <a href="http://en.wikipedia.org/wiki/Venezuela">Bolivarian Republic of Venezuela</a> */
    Bolivarian_Republic_of_Venezuela("VE", "VEN", 862),

    /** <a href="http://en.wikipedia.org/wiki/British_Virgin_Islands">British Virgin Islands</a> */
    British_Virgin_Islands("VG", "VGB", 92),

    /** <a href="http://en.wikipedia.org/wiki/United_States_Virgin_Islands">Virgin Islands, U.S.</a> */
    Virgin_Islands_United_States("VI", "VIR", 850),

    /** <a href="http://en.wikipedia.org/wiki/Vietnam">Viet Nam</a> */
    Viet_Nam("VN", "VNM", 704),

    /** <a href="http://en.wikipedia.org/wiki/Vanuatu">Vanuatu</a> */
    Vanuatu("VU", "VUT", 548),

    /** <a href="http://en.wikipedia.org/wiki/Wallis_and_Futuna">Wallis and Futuna</a> */
    Wallis_and_Futuna("WF", "WLF", 876),

    /** <a href="http://en.wikipedia.org/wiki/Samoa">Samoa</a> */
    Samoa("WS", "WSM", 882),

    /** <a href="http://en.wikipedia.org/wiki/Yemen">Yemen</a> */
    Yemen("YE", "YEM", 887),

    /** <a href="http://en.wikipedia.org/wiki/Mayotte">Mayotte</a> */
    Mayotte("YT", "MYT", 175),

    /** <a href="http://en.wikipedia.org/wiki/South_Africa">South Africa</a> */
    South_Africa("ZA", "ZAF", 710),

    /** <a href="http://en.wikipedia.org/wiki/Zambia">Zambia</a> */
    Zambia("ZM", "ZMB", 894),

    /** <a href="http://en.wikipedia.org/wiki/Zimbabwe">Zimbabwe</a> */
    Zimbabwe("ZW", "ZWE", 716),
    ;
    // @formatter:on


    private static final Map<String, CountryCode> alpha3Map = new HashMap<String, CountryCode>();
    private static final Map<Integer, CountryCode> numericMap = new HashMap<Integer, CountryCode>();


    static
    {
        for (CountryCode cc : values())
        {
            alpha3Map.put(cc.getAlpha3(), cc);
            numericMap.put(cc.getNumeric(), cc);
        }
    }


    private final String name;
    private final String alpha3;
    private final int numeric;


    private CountryCode(String name, String alpha3, int numeric)
    {
        this.name = name;
        this.alpha3 = alpha3;
        this.numeric = numeric;
    }


    /**
     * Get the country name.
     *
     * @return
     *         The country name.
     */
    public String getName()
    {
        return name;
    }


    /**
     * Get the <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2"
     * >ISO 3166-1 alpha-2</a> code.
     *
     * @return
     *         The <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2"
     *         >ISO 3166-1 alpha-2</a> code.
     */
    public String getAlpha2()
    {
        return name();
    }


    /**
     * Get the <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-3"
     * >ISO 3166-1 alpha-3</a> code.
     *
     * @return
     *         The <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-3"
     *         >ISO 3166-1 alpha-3</a> code.
     */
    public String getAlpha3()
    {
        return alpha3;
    }


    /**
     * Get the <a href="http://en.wikipedia.org/wiki/ISO_3166-1_numeric"
     * >ISO 3166-1 numeric</a> code.
     *
     * @return
     *         The <a href="http://en.wikipedia.org/wiki/ISO_3166-1_numeric"
     *         >ISO 3166-1 numeric</a> code.
     */
    public int getNumeric()
    {
        return numeric;
    }


    /**
     * Get a CountryCode that corresponds to a given ISO 3166-1
     * <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">alpha-2</a> or
     * <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-3">alpha-3</a> code.
     *
     * @param code
     *         An ISO 3166-1 <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2"
     *         >alpha-2</a> or <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-3"
     *         >alpha-3</a> code.
     *
     * @return
     *         A CountryCode instance, or null if not found.
     */
    public static CountryCode getByCode(String code)
    {
        if (code == null)
        {
            return null;
        }

        switch (code.length())
        {
            case 2:
                return getByAlpha2Code(code);

            case 3:
                return getByAlpha3Code(code);

            default:
                return null;
        }
    }


    private static CountryCode getByAlpha2Code(String code)
    {
        try
        {
            return Enum.valueOf(CountryCode.class, code);
        }
        catch (IllegalArgumentException e)
        {
            return null;
        }
    }


    private static CountryCode getByAlpha3Code(String code)
    {
        return alpha3Map.get(code);
    }


    /**
     * Get a CountryCode that corresponds to a given
     * <a href="http://en.wikipedia.org/wiki/ISO_3166-1_numeric">ISO 3166-1
     * numeric</a> code.
     *
     * @param code
     *         An <a href="http://en.wikipedia.org/wiki/ISO_3166-1_numeric"
     *         >ISO 3166-1 numeric</a> code.
     *
     * @return
     *         A CountryCode instance, or null if not found.
     */
    public static CountryCode getByCode(int code)
    {
        return numericMap.get(code);
    }
}

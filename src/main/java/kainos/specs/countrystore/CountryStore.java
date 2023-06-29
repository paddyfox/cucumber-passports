package kainos.specs.countrystore;

import com.google.common.collect.Lists;
import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Hashmap of all active standard countries with: valid house phone number, mobile number (no area code) and postcode
@UtilityClass
public class CountryStore {
    public static final Map<String, List<String>> countryHashMap = new HashMap<>();

    static {
        //France
        countryHashMap.put("FR", Lists.newArrayList("+33", "155260505", "612345678", "75010", "France", "1", "Ffrainc"));
        //Germany
        countryHashMap.put("DE", Lists.newArrayList("+49", "895999250", "15123456789", "80336", "Germany", "1", "Yr Almaen"));
    }

    public static final Map<String, String> contentType7countryHashMap = new HashMap<>();

    static {
        //Yemen
        contentType7countryHashMap.put("YE", "Yemen");
        //Iran
        contentType7countryHashMap.put("IR", "Iran");
        //Syria
        contentType7countryHashMap.put("SY", "Syria");
        //Libya
        contentType7countryHashMap.put("LY", "Libya");
        //North Korea
        contentType7countryHashMap.put("KP", "North Korea");
        //South Georgia and the South Sandwich Islands
        contentType7countryHashMap.put("GS", "South Georgia and the South Sandwich Islands");
        //British Indian Ocean Territory
        contentType7countryHashMap.put("IO", "British Indian Ocean Territory");
    }

    public static final Map<String, String> ovsPaperChannelCountryHashMap = new HashMap<>();

    static {
        //Group1 Countries - Paper Channel
        //Falkland Islands
        ovsPaperChannelCountryHashMap.put("FK", "Falkland Islands");
        //Gibraltar
        ovsPaperChannelCountryHashMap.put("GI", "Gibraltar");
        //Jordan
        ovsPaperChannelCountryHashMap.put("JO", "Jordan");
        //Pitcairn Island
        ovsPaperChannelCountryHashMap.put("PN", "Pitcairn Island");
        //St Helena Ascension & Tristan da Cunha
        ovsPaperChannelCountryHashMap.put("SH", "St Helena Ascension & Tristan da Cunha");
        //The Occupied Palestinian Territories - Gaza
        ovsPaperChannelCountryHashMap.put("PZ", "The Occupied Palestinian Territories - Gaza");
        //The Occupied Palestinian Territories - Jerusalem and the West Bank
        ovsPaperChannelCountryHashMap.put("PJ", "The Occupied Palestinian Territories - Jerusalem and the West Bank");

        //Group2 Countries - Paper Channel
        //China
        ovsPaperChannelCountryHashMap.put("CN", "China");
        //Cuba
        ovsPaperChannelCountryHashMap.put("CU", "Cuba");
        //Georgia
        ovsPaperChannelCountryHashMap.put("GE", "Georgia");
        //Indonesia
        ovsPaperChannelCountryHashMap.put("ID", "Indonesia");
        //Thailand
        ovsPaperChannelCountryHashMap.put("TH", "Thailand");
        //Tunisia
        ovsPaperChannelCountryHashMap.put("TN", "Tunisia");

        //Group3 Countries - Paper Channel
        //Afghanistan
        ovsPaperChannelCountryHashMap.put("AF", "Afghanistan");
        //Algeria
        ovsPaperChannelCountryHashMap.put("DZ", "Algeria");
        //Angola
        ovsPaperChannelCountryHashMap.put("AO", "Angola");
        //Azerbaijan
        ovsPaperChannelCountryHashMap.put("AZ", "Azerbaijan");
        //Bangladesh
        ovsPaperChannelCountryHashMap.put("BD", "Bangladesh");
        //Belarus
        ovsPaperChannelCountryHashMap.put("BY", "Belarus");
        //Benin
        ovsPaperChannelCountryHashMap.put("BJ", "Benin");
        //Burma
        ovsPaperChannelCountryHashMap.put("MM", "Myanmar-Burma");
        //Burundi
        ovsPaperChannelCountryHashMap.put("BI", "Burundi");
        //Cambodia
        ovsPaperChannelCountryHashMap.put("KH", "Cambodia");
        //Cameroon
        ovsPaperChannelCountryHashMap.put("CM", "Cameroon");
        //Chad
        ovsPaperChannelCountryHashMap.put("TD", "Chad");
        //Congo
        ovsPaperChannelCountryHashMap.put("CG", "Congo");
        //Egypt
        ovsPaperChannelCountryHashMap.put("EG", "Egypt");
        //Eritrea
        ovsPaperChannelCountryHashMap.put("ER", "Eritrea");
        //Ethiopia
        ovsPaperChannelCountryHashMap.put("ET", "Ethiopia");
        //Gambia
        ovsPaperChannelCountryHashMap.put("GM", "The Gambia");
        //Ghana
        ovsPaperChannelCountryHashMap.put("GH", "Ghana");
        //Guinea
        ovsPaperChannelCountryHashMap.put("GN", "Guinea");
        //India
        ovsPaperChannelCountryHashMap.put("IN", "India");
        //Iraq
        ovsPaperChannelCountryHashMap.put("IQ", "Iraq");
        //Jamaica
        ovsPaperChannelCountryHashMap.put("JM", "Jamaica");
        //Kazakhstan
        ovsPaperChannelCountryHashMap.put("KZ", "Kazakhstan");
        //Kenya
        ovsPaperChannelCountryHashMap.put("KE", "Kenya");
        //Laos
        ovsPaperChannelCountryHashMap.put("LA", "Laos");
        //Kyrgyzstan
        ovsPaperChannelCountryHashMap.put("KG", "Kyrgyzstan");
        //Lebanon
        ovsPaperChannelCountryHashMap.put("LB", "Lebanon");
        //Mauritania
        ovsPaperChannelCountryHashMap.put("MR", "Mauritania");
        //Morocco
        ovsPaperChannelCountryHashMap.put("MA", "Morocco");
        //Nepal
        ovsPaperChannelCountryHashMap.put("NP", "Nepal");
        //Nigeria
        ovsPaperChannelCountryHashMap.put("NG", "Nigeria");
        //Pakistan
        ovsPaperChannelCountryHashMap.put("PK", "Pakistan");
        //Russia
        ovsPaperChannelCountryHashMap.put("RU", "Russia");
        //Rwanda
        ovsPaperChannelCountryHashMap.put("RW", "Rwanda");
        //Sierra Leone
        ovsPaperChannelCountryHashMap.put("SL", "Sierra Leone");
        //Somalia
        ovsPaperChannelCountryHashMap.put("SO", "Somalia");
        //South Sudan
        ovsPaperChannelCountryHashMap.put("SS", "South Sudan");
        //Sri Lanka
        ovsPaperChannelCountryHashMap.put("LK", "Sri Lanka");
        //Sudan
        ovsPaperChannelCountryHashMap.put("SD", "Sudan");
        //Tajikistan
        ovsPaperChannelCountryHashMap.put("TJ", "Tajikistan");
        //Timor Leste
        ovsPaperChannelCountryHashMap.put("TL", "Timor-Leste");
        //Turkmenistan
        ovsPaperChannelCountryHashMap.put("TM", "Turkmenistan");
        //Uganda
        ovsPaperChannelCountryHashMap.put("UG", "Uganda");
        //Ukraine
        ovsPaperChannelCountryHashMap.put("UA", "Ukraine");
        //Uzbekistan
        ovsPaperChannelCountryHashMap.put("UZ", "Uzbekistan");
        //Venezuela
        ovsPaperChannelCountryHashMap.put("VE", "Venezuela");
        //Vietnam
        ovsPaperChannelCountryHashMap.put("VN", "Vietnam");
        //Western Sahara
        ovsPaperChannelCountryHashMap.put("EH", "Western Sahara");
        //Zambia
        ovsPaperChannelCountryHashMap.put("ZM", "Zambia");
        //Zimbabwe
        ovsPaperChannelCountryHashMap.put("ZW", "Zimbabwe");
    }

    public static final Map<String, List<String>> ovsDAPThreatLevelCountryHashMap = new HashMap<>();

    static {
        //Threat level STANDARD countries
        ovsDAPThreatLevelCountryHashMap.put("AS", Lists.newArrayList("American Samoa", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("AD", Lists.newArrayList("Andorra", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("AR", Lists.newArrayList("Argentina", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("AW", Lists.newArrayList("Aruba", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("AU", Lists.newArrayList("Australia", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("AT", Lists.newArrayList("Austria", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("BH", Lists.newArrayList("Bahrain", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("BE", Lists.newArrayList("Belgium", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("BT", Lists.newArrayList("Bhutan", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("BQ", Lists.newArrayList("Bonaire/St Eustatius/Saba", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("BN", Lists.newArrayList("Brunei", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("CA", Lists.newArrayList("Canada", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("CL", Lists.newArrayList("Chile", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("CR", Lists.newArrayList("Costa Rica", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("HR", Lists.newArrayList("Croatia", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("CW", Lists.newArrayList("Curacao", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("CY", Lists.newArrayList("Cyprus", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("CZ", Lists.newArrayList("Czech Republic", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("DK", Lists.newArrayList("Denmark", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("EE", Lists.newArrayList("Estonia", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("FI", Lists.newArrayList("Finland", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("FR", Lists.newArrayList("France", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("GF", Lists.newArrayList("French Guiana", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("PF", Lists.newArrayList("French Polynesia", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("DE", Lists.newArrayList("Germany", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("GP", Lists.newArrayList("Guadeloupe", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("HU", Lists.newArrayList("Hungary", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("IS", Lists.newArrayList("Iceland", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("IE", Lists.newArrayList("Ireland", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("IL", Lists.newArrayList("Israel", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("JP", Lists.newArrayList("Japan", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("KI", Lists.newArrayList("Kiribati", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("KW", Lists.newArrayList("Kuwait", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("LV", Lists.newArrayList("Latvia", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("LI", Lists.newArrayList("Liechtenstein", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("LT", Lists.newArrayList("Lithuania", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("LU", Lists.newArrayList("Luxembourg", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("MO", Lists.newArrayList("Macao", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("MY", Lists.newArrayList("Malaysia", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("MT", Lists.newArrayList("Malta", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("MH", Lists.newArrayList("Marshall Islands", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("MQ", Lists.newArrayList("Martinique", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("YT", Lists.newArrayList("Mayotte", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("FM", Lists.newArrayList("Micronesia", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("MC", Lists.newArrayList("Monaco", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("NR", Lists.newArrayList("Nauru", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("NL", Lists.newArrayList("Netherlands", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("NC", Lists.newArrayList("New Caledonia", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("NZ", Lists.newArrayList("New Zealand", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("NO", Lists.newArrayList("Norway", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("OM", Lists.newArrayList("Oman", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("PW", Lists.newArrayList("Palau", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("PL", Lists.newArrayList("Poland", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("PT", Lists.newArrayList("Portugal", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("QA", Lists.newArrayList("Qatar", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("RE", Lists.newArrayList("Reunion", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("BL", Lists.newArrayList("St Barthelemy", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("WS", Lists.newArrayList("Samoa", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("SM", Lists.newArrayList("San Marino", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("SA", Lists.newArrayList("Saudi Arabia", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("SC", Lists.newArrayList("Seychelles", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("SG", Lists.newArrayList("Singapore", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("SK", Lists.newArrayList("Slovakia", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("SI", Lists.newArrayList("Slovenia", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("KR", Lists.newArrayList("South Korea", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("ES", Lists.newArrayList("Spain", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("SX", Lists.newArrayList("St Maarten", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("MF", Lists.newArrayList("St Martin", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("PM", Lists.newArrayList("St Pierre & Miquelon", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("SE", Lists.newArrayList("Sweden", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("CH", Lists.newArrayList("Switzerland", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("TW", Lists.newArrayList("Taiwan", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("TO", Lists.newArrayList("Tonga", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("TV", Lists.newArrayList("Tuvalu", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("AE", Lists.newArrayList("United Arab Emirates", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("UY", Lists.newArrayList("Uruguay", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("US", Lists.newArrayList("USA", "Standard"));
        ovsDAPThreatLevelCountryHashMap.put("WF", Lists.newArrayList("Wallis and Futuna", "Standard"));

        //Threat level HEIGHTENED countries
        ovsDAPThreatLevelCountryHashMap.put("AI", Lists.newArrayList("Anguilla", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("AG", Lists.newArrayList("Antigua and Barbuda", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("AM", Lists.newArrayList("Armenia", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("BS", Lists.newArrayList("Bahamas", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("BB", Lists.newArrayList("Barbados", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("BZ", Lists.newArrayList("Belize", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("BM", Lists.newArrayList("Bermuda", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("BA", Lists.newArrayList("Bosnia and Herzegovina", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("BW", Lists.newArrayList("Botswana", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("BR", Lists.newArrayList("Brazil", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("VG", Lists.newArrayList("British Virgin Islands", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("BG", Lists.newArrayList("Bulgaria", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("CV", Lists.newArrayList("Cape Verde", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("KY", Lists.newArrayList("Cayman Islands", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("CO", Lists.newArrayList("Colombia", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("KM", Lists.newArrayList("Comoros", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("DM", Lists.newArrayList("Dominica", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("SV", Lists.newArrayList("El Salvador", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("FJ", Lists.newArrayList("Fiji", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("GR", Lists.newArrayList("Greece", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("GD", Lists.newArrayList("Grenada", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("GT", Lists.newArrayList("Guatemala", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("HN", Lists.newArrayList("Honduras", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("HK", Lists.newArrayList("Hong Kong", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("IT", Lists.newArrayList("Italy", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("LS", Lists.newArrayList("Lesotho", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("MK", Lists.newArrayList("North Macedonia", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("MV", Lists.newArrayList("Maldives", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("MX", Lists.newArrayList("Mexico", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("ME", Lists.newArrayList("Montenegro", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("MS", Lists.newArrayList("Montserrat", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("NA", Lists.newArrayList("Namibia", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("NI", Lists.newArrayList("Nicaragua", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("PA", Lists.newArrayList("Panama", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("PG", Lists.newArrayList("Papua New Guinea", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("PE", Lists.newArrayList("Peru", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("RO", Lists.newArrayList("Romania", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("ST", Lists.newArrayList("Sao Tome and Principe", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("RS", Lists.newArrayList("Serbia", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("SB", Lists.newArrayList("Solomon Islands", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("ZA", Lists.newArrayList("South Africa", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("KN", Lists.newArrayList("St Kitts and Nevis", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("LC", Lists.newArrayList("St Lucia", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("VC", Lists.newArrayList("St Vincent and The Grenadines", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("SR", Lists.newArrayList("Suriname", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("SZ", Lists.newArrayList("Eswatini", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("TR", Lists.newArrayList("Turkey", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("TC", Lists.newArrayList("Turks and Caicos Islands", "Heightened"));
        ovsDAPThreatLevelCountryHashMap.put("VU", Lists.newArrayList("Vanuatu", "Heightened"));
    }

}

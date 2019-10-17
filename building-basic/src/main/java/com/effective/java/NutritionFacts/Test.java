package com.effective.java.NutritionFacts;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 14:21 2019/9/17.
 */
public class Test {
    public static void main(String[] args) {
        String fields = "NORDINE, NWEB, DATA, CODCLIWEB, T_CLIENTE, T_INDIRIZZO, T_CITTA, T_CAP, T_PROV, T_CODFISC, T_PIVA, T_MODPAG, T_EMAIL, SPED_NOME, SPED_COGNOME, SPED_IND, SPED_CAP, SPED_CITTA, SPED_PROV, SPED_TEL, SPED_TIPO, SPED_NAZIONE, CORRIERE, T_ESENTE, STATO";
        String resp = "{\"ID\":603454,\"NORDINE\":\"PRIVALIA199539451-A\",\"NWEB\":\"199539451-A\",\"DATA\":\"22/02/2019 15:10:41\",\"CODCLIWEB\":548018,\"T_CLIENTE\":\"PAPPAGALLO RITA\",\"T_INDIRIZZO\":\"VIA Subiaco 35\",\"T_CITTA\":\"Setteville nord, Guidonia Montecelio\",\"T_CAP\":\"00012\",\"T_PROV\":null,\"T_CODFISC\":null,\"T_PIVA\":null,\"T_MODPAG\":\"Marketplaces\",\"T_EMAIL\":\"privalia199539451-a@fantasiacalzature.it\",\"SPED_NOME\":\"RITA\",\"SPED_COGNOME\":\"PAPPAGALLO\",\"SPED_IND\":\"VIA Subiaco 35 note : \",\"SPED_CAP\":\"00012\",\"SPED_CITTA\":\"Setteville nord, Guidonia Montecelio\",\"SPED_PROV\":\"Roma\",\"SPED_TEL\":\"3280639069\",\"SPED_TIPO\":\"ITALIA\",\"SPED_NAZIONE\":\"Italy\",\"DOCUMENTO_OUT\":null,\"STATO\":\"PV\",\"CORRIERE\":\"SDA\",\"T_ESENTE\":null,\"STAMPATO\":\"S\",\"CTRL\":\"OTS\",\"DTMOVOTS\":\"22/02/2019 16: 00: 26\",\"FE_PEC\":null,\"FE_PIVA\":null,\"FE_CODFISC\":null,\"FE_COMUNE\":null,\"FE_PROV\":null,\"T_PEC\":null,\"T_SID\":null,\"URL\":null,\"FE_NAZIONE\":null}";
        for (String field : fields.split(", *")) {
            if (!resp.contains(field)) {
                System.out.println(field);
            }
        }
    }

}
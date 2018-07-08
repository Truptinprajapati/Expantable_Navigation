package com.example.nepl2.navigationdrawerdemo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ExpandableListDataPump {

    public static HashMap<String, List<String>> getData() {
        LinkedHashMap<String, List<String>> expandableListDetail = new LinkedHashMap<String, List<String>>();


        List<String> aboutBJPList = new ArrayList<String>();
//        aboutBJPList.add("Founder");
//        aboutBJPList.add("Ideologue");
//        aboutBJPList.add("Time Line");

        List<String> searchmembers = new ArrayList<String>();

        searchmembers.add("Report 1");
        searchmembers.add("Report 2");

        List<String> orderlist = new ArrayList<String>();


        expandableListDetail.put("રાષ્ટ્રીય સંગઠનની માહિતી",orderlist);
        expandableListDetail.put("પ્રદેશ સંગઠનની માહિતી ", orderlist);
        expandableListDetail.put("કર્ણાવતી મહાનગર સંગઠનની માહિતી  ", orderlist);
        expandableListDetail.put("લોકસભાની માહિતી ", orderlist);
        expandableListDetail.put("વિધાનસભાની માહિતી ", orderlist);
        expandableListDetail.put("વોર્ડની માહિતી ", orderlist);
        expandableListDetail.put("સભ્યો શોધો", searchmembers);
        expandableListDetail.put("ટેલીફોન ડીરેક્ટરી", orderlist);
        expandableListDetail.put("રિપોર્ટ્સ", orderlist);
        expandableListDetail.put("અન્ય", aboutBJPList);


        return expandableListDetail;
    }

}

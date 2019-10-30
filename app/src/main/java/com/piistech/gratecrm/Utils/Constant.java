package com.piistech.gratecrm.Utils;


import com.piistech.gratecrm.Model.ColorItem;

import java.util.ArrayList;

public class Constant {
    public static final int REALM_MIGRATION_VERSION = 0;
    public static final String LOCAL_DATABASE_NAME = "LOCAL_DATABASE";
    public static final ArrayList<ColorItem> COLOR_ARRAY = new ArrayList<ColorItem>(){
        {
            add( new ColorItem(false,"#ff5722"));
            add( new ColorItem(false,"#D50000"));
            add( new ColorItem(false,"#C51162"));
            add( new ColorItem(false,"#AA00FF"));
            add( new ColorItem(false,"#6200EA"));
            add( new ColorItem(false,"#304FFE"));
            add( new ColorItem(false,"#2962FF"));
            add( new ColorItem(false,"#0091EA"));
            add( new ColorItem(false,"#00B8D4"));
            add( new ColorItem(false,"#00BFA5"));
            add( new ColorItem(false,"#00C853"));
            add( new ColorItem(false,"#64DD17"));
            add( new ColorItem(false,"#AEEA00"));
            add( new ColorItem(false,"#FFD600"));
            add( new ColorItem(false,"#FFAB00"));
            add( new ColorItem(false,"#FF6D00"));
            add( new ColorItem(false,"#DD2C00"));
            add( new ColorItem(false,"#795548"));
            add( new ColorItem(false,"#9e9e9e"));
            add( new ColorItem(false,"#607d8b"));
            add( new ColorItem(true,"#252525"));
            add( new ColorItem(false,"#FFFFFF"));
        }
    };
}

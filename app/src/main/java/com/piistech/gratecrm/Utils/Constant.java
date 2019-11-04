package com.piistech.gratecrm.Utils;


import android.view.View;
import android.widget.CheckBox;

import com.google.android.material.textfield.TextInputLayout;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.piistech.gratecrm.Model.ColorItem;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Constant {
    public static final int REALM_MIGRATION_VERSION = 0;
    public static final String LOCAL_DATABASE_NAME = "LOCAL_DATABASE";
    public static final int SOCKET_TIMEOUT = 30000;
    public static final String API_STATUS = "API_STATUS";
    public static final String API_RESULT = "API_RESULT";
    private static final String ERROR_MESSAGE = "* Required";
    public static final String INPUT_USERNAME = "INPUT_USERNAME";
    public static final String INPUT_PASSWORD = "INPUT_PASSWORD";
    public static final String INPUT_REMEMBER_ME = "INPUT_REMEMBER_ME";
    public static final String IS_AUTHENTICATED_USER = "IS_AUTHENTICATED_USER";
    public static final String API_TOKEN = "API_TOKEN";
    public static final String EXPIRE_TIME = "EXPIRE_TIME";

    ///TODO: ------------------------------BROADCAST ID FOR RECEIVE --------------------------------
    public static final String BROADCAST_ID_FOR_LOGIN = "BROADCAST_ID_FOR_LOGIN";
    public static final String BROADCAST_ID_FOR_DASHBOARD = "BROADCAST_ID_FOR_DASHBOARD";
    public static final String BROADCAST_ID_FOR_TOKEN_EXPIRE = "BROADCAST_ID_FOR_TOKEN_EXPIRE";
    public static final String BROADCAST_ID_FOR_CUSTOMER_DETAILS = "BROADCAST_ID_FOR_CUSTOMER_DETAILS";
    public static final String BROADCAST_ID_FOR_SAVE_CUSTOMER = "BROADCAST_ID_FOR_SAVE_CUSTOMER";

    ///TODO: -------------------------------API RESOURCES VALIDATION--------------------------------
    public static final String API_URL = "http://api.rmrcloud.com/";
    public static final String API_NAME_TOKEN = "token";
    public static final String API_NAME_GET_ALL_CUSTOMER = "GetAllCustomer";
    public static final String API_NAME_GET_CUSTOMER_BY_ID = "GetCustomerById";
    public static final String API_NAME_SAVE_CUSTOMER = "SaveCustomer";

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

    ///TODO: -----------------------------------INPUT VALIDATION------------------------------------
    public static boolean validateInput(TextInputLayout input) {
        input.setErrorEnabled(false);
        if (isNull(input) || input.getEditText().getText().toString().isEmpty()) {
            input.setErrorEnabled(false);
            input.setError(ERROR_MESSAGE);
            return false;
        } else return true;
    }

    public static boolean validateInput(MaterialSpinner input) {
        if (isNull(input) || input.getSelectedIndex()==0) {
            input.setError(ERROR_MESSAGE);
            return false;
        } else return true;
    }

    private static boolean isNull(View view) {
        if (view == null) return true;
        else return false;
    }

    private static boolean isNull(String string) {
        if (string == null) return true;
        else return false;
    }

    private static boolean checkValue(String address) {
        return address != null && !address.isEmpty() && !address.equals("null") && !address.equals("0");
    }


    private static boolean checkAddress(String address) {
        return address != null && !address.isEmpty() && !address.equals("null") && !address.equals("0");
    }

    private static boolean checkTown(String town) {
        return checkAddress(town);
    }

    private static boolean checkZip(String zip) {
        return checkAddress(zip);
    }

    ///TODO: ---------------------------------------PARSE JSON--------------------------------------
    public static String valueOfString(JSONObject json, String key) {
        try {
            return json.getString(key);
        } catch (JSONException e) {
            return null;
        }
    }
    public static int valueOfInt(JSONObject json, String key) {
        try {
            return json.getInt(key);
        } catch (JSONException e) {
            return 0;
        }
    }


    ///TODO: --------------------------------------PARSE INPUT--------------------------------------
    public static String valueOf(TextInputLayout input) {
        if (isNull(input) || input.getEditText().getText().toString().isEmpty()) {
            return null;
        } else return input.getEditText().getText().toString();
    }

    public static boolean valueOf(CheckBox input) {
        if (isNull(input)) {
            return false;
        } else return input.isChecked();
    }

    public static String valueOf(MaterialSpinner input) {
        if (isNull(input)) {
            return null;
        } else return (String) input.getItems().get(input.getSelectedIndex());
    }

    ///TODO: --------------------------------------DATA VISUAL FORMATTER----------------------------

    public static String NameFormatter(String firstName, String lastName) {
        return !firstName.isEmpty() && !lastName.isEmpty() ? firstName + " " + lastName : (firstName.isEmpty() ? lastName : (lastName.isEmpty() ? firstName : "-"));
    }

    public static String PhoneFormatter(String telephone, String mobile, String email) {
        return (checkValue(telephone) ? telephone : (checkValue(mobile) ? mobile : (checkValue(email) ? email : "-")));
    }

    public static String AddressFormatter(String address, String street, String town, String state, String zip) {
        if (checkAddress(address)) {
            if (checkAddress(street)) {
                if (checkTown(town)) {
                    if (checkZip(state)) {
                        if (checkZip(zip)) {
                            return address + " " + street + "\n" + town + ", " + state + " " + zip;
                        } else {
                            return address + " " + street + "\n" + town + ", " + state;
                        }
                    } else {
                        if (checkZip(zip)) {
                            return address + " " + street + "\n" + town + ", " + zip;
                        } else {
                            return address + " " + street + "\n" + town;
                        }
                    }
                } else {
                    if (checkZip(state)) {
                        if (checkZip(zip)) {
                            return address + " " + street + "\n" + state + " " + zip;
                        } else {
                            return address + " " + street + "\n" + state;
                        }
                    } else {
                        if (checkZip(zip)) {
                            return address + " " + street + "\n" + zip;
                        } else {
                            return address + " " + street;
                        }
                    }
                }
            } else {
                if (checkTown(town)) {
                    if (checkZip(state)) {
                        if (checkZip(zip)) {
                            return address + " " + town + ", " + state + " " + zip;
                        } else {
                            return address + " " + town + ", " + state;
                        }
                    } else {
                        if (checkZip(zip)) {
                            return address + " " + town + ", " + zip;
                        } else {
                            return address + " " + town;
                        }
                    }
                } else {
                    if (checkZip(state)) {
                        if (checkZip(zip)) {
                            return address + " " + state + " " + zip;
                        } else {
                            return address + " " + state;
                        }
                    } else {
                        if (checkZip(zip)) {
                            return address + " " + zip;
                        } else {
                            return address;
                        }
                    }
                }
            }
        } else {
            if (checkAddress(street)) {
                if (checkTown(town)) {
                    if (checkZip(state)) {
                        if (checkZip(zip)) {
                            return street + "\n" + town + ", " + state + " " + zip;
                        } else {
                            return street + "\n" + town + ", " + state;
                        }
                    } else {
                        if (checkZip(zip)) {
                            return street + "\n" + town + ", " + zip;
                        } else {
                            return street + "\n" + town;
                        }
                    }
                } else {
                    if (checkZip(state)) {
                        if (checkZip(zip)) {
                            return street + "\n" + state + " " + zip;
                        } else {
                            return street + "\n" + state;
                        }
                    } else {
                        if (checkZip(zip)) {
                            return street + "\n" + zip;
                        } else {
                            return street;
                        }
                    }
                }
            } else {
                if (checkTown(town)) {
                    if (checkZip(state)) {
                        if (checkZip(zip)) {
                            return town + ", " + state + " " + zip;
                        } else {
                            return town + ", " + state;
                        }
                    } else {
                        if (checkZip(zip)) {
                            return town + ", " + zip;
                        } else {
                            return town;
                        }
                    }
                } else {
                    if (checkZip(state)) {
                        if (checkZip(zip)) {
                            return state + " " + zip;
                        } else {
                            return state;
                        }
                    } else {
                        if (checkZip(zip)) {
                            return zip;
                        } else {
                            return "-";
                        }
                    }
                }
            }
        }
    }

}

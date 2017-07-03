package com.fino;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadPropertyFile {
	
	private Properties propertyLoad;
    public Properties readPropertyFile(final String pFileName) {   
    			InputStream fileSource = null;
                try {
                            fileSource = this.getClass().getResourceAsStream(pFileName);
                            FileInputStream inFile = new FileInputStream("F:\\seleinum\\OBC_PROJECT\\src\\common.properties");
                	        propertyLoad = new Properties();
                            propertyLoad.load(inFile);
                } catch (IOException e) {
                            e.printStackTrace();
                }
                finally {
                            if(fileSource!=null)
                            {
                                        try {
                                                    fileSource.close();
                                        } catch (IOException e) 
                                        {

                                        	e.printStackTrace();
                                        }
                            }
                }
                return propertyLoad;       
    }


}

/**
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.neo4art.api.util;

import java.text.SimpleDateFormat;
import java.util.Locale;

import org.neo4art.domain.Artwork;


/**
 * @author Enrico De Benetti
 * @since 02 Mag 2015
 *
 */
public class ServicesUtil {

    private static ServicesUtil instance = null;
    private SimpleDateFormat format;
    private static final String DATE_FORMAT_COMPLETITION_DATE = "dd-MMM-yyyy HH:mm";
    
	private ServicesUtil(){
		
      format = new SimpleDateFormat(DATE_FORMAT_COMPLETITION_DATE,Locale.ENGLISH);	
	}
	
	public static ServicesUtil getInstance(){
		
		if(instance == null){
			
			instance = new ServicesUtil();
		}
		
		return instance;
	}
	
	public String verifyArtworkDate(Artwork artwork){
		
	 String result="";
	
	  try
	  {
		 
	   if(artwork != null && artwork.getCompletionDate() != null)
	   {
	      result = format.format(artwork.getCompletionDate()); 
	   }
	   else if(artwork != null)
	   {
		 result = "10-Jan-"+artwork.getYear()+" 00:00";
	   }
	  }
	  catch (Exception e)
	  {
	  }
		  
	 return result;	
	}
	
}
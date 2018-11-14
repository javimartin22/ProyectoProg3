import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class methods {

	public void Webscrape(String dia,String mes,String anyo, String dia1, String mes1, String anyo1, String ciudad, String codigo) {
		
		final String url="https://espanol.wunderground.com/history/airport/"+codigo+"/"+anyo+"/"+mes+"/"+dia+"/CustomHistory.html?dayend="+dia1+"&monthend="+mes1+"&yearend="+anyo1+"&req_city=&req_state=&req_statename=&reqdb.zip=&reqdb.magic=&reqdb.wmo=";
		ArrayList<DiaRegistrado> diasregistrados = new ArrayList<DiaRegistrado>();
		try {
			final Document document=Jsoup.connect(url).get();
			
			for (Element row : document.select(
					"table.responsive.obs-table.daily tr")) {
				if(row.select("td:nth-of-type(1)").text().equals("Ene")||row.select("td:nth-of-type(1)").text().equals("Feb")||row.select("td:nth-of-type(1)").text().equals("Mar")||row.select("td:nth-of-type(1)").text().equals("Abr")||row.select("td:nth-of-type(1)").text().equals("May")||row.select("td:nth-of-type(1)").text().equals("Jun")||row.select("td:nth-of-type(1)").text().equals("Jul")||row.select("td:nth-of-type(1)").text().equals("Ago")||row.select("td:nth-of-type(1)").text().equals("Sep")||row.select("td:nth-of-type(1)").text().equals("Oct")||row.select("td:nth-of-type(1)").text().equals("Nov")||row.select("td:nth-of-type(1)").text().equals("Dic")) {
					continue;
				}
				else {
					

					try {
						final String snumDia=row.select("td:nth-of-type(1)").text();
						
						final int numDia=Integer.parseInt(snumDia);
						
                          
						 final String stempHigh=row.select("td:nth-of-type(2)").text();
						final int tempHigh= Integer.parseInt(stempHigh);
						
						final String stempAvg=row.select("td:nth-of-type(3)").text();
						final int tempAvg= Integer.parseInt(stempAvg);
						final String stempLow=row.select("td:nth-of-type(4)").text();
						final int tempLow= Integer.parseInt(stempLow);
						final String srocioHigh=row.select("td:nth-of-type(5)").text();
						final int rocioHigh= Integer.parseInt(srocioHigh);
						final String srocioAvg=row.select("td:nth-of-type(6)").text();
						final int rocioAvg= Integer.parseInt(srocioAvg);
						final String srocioLow=row.select("td:nth-of-type(7)").text();
						final int rocioLow= Integer.parseInt(srocioLow);
						final String shumedadHigh=row.select("td:nth-of-type(8)").text();
						final int humedadHigh= Integer.parseInt(shumedadHigh);
						final String shumedadAvg=row.select("td:nth-of-type(9)").text();
						final int humedadAvg= Integer.parseInt(shumedadAvg);
						final String shumedadLow=row.select("td:nth-of-type(10)").text();
						final int humedadLow= Integer.parseInt(shumedadLow);
						final String sprecip=row.select("td:nth-of-type(20)").text();
						final double precip=Double.parseDouble(sprecip);
						
						DiaRegistrado d=new DiaRegistrado(numDia,tempHigh,tempAvg,tempLow,rocioHigh,rocioAvg,rocioLow,humedadHigh,humedadAvg,humedadLow,precip);
					   System.out.println(d.toString());
						diasregistrados.add(d);
						
					} catch (NumberFormatException n) {
					    // ... Do nothing.
					}

					
					
				}
			}
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}

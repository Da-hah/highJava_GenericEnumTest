package kr.or.ddit.basic.homework;


public class Planet {
	
	
	public enum PlanetEnum{
		수성(2439), 
		금성(6052), 
		지구(6371), 
		화성(3390), 
		목성(69911), 
		토성(58232), 
		천왕성(25362), 
		해왕성(24622);
		
		private int radius;
		
		PlanetEnum(int radius){
			this.radius = radius;
		}
		public int getRadius() {
			return radius;
		}
		
	}
	
	public static void main(String[] args) {
		PlanetEnum[] enumArr = PlanetEnum.values();
		
		for(PlanetEnum p : enumArr) {
			long area = (long)(4*Math.PI*p.getRadius()*p.getRadius());
			System.out.println(p.name()+" 의 면적 : "+ area);
		}
	}
}


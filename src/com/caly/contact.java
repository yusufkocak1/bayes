package com.caly;



public class contact {
	private String name;
	private String givebirth;
	private String canfly;
	private String livewater;
	private String havelegs;
	private String clas;
	


	public contact(Builder builder) {
		this.name = builder.name;
		this.givebirth = builder.givebirth;
		this.canfly = builder.canfly;
		this.livewater = builder.livewater;
		this.havelegs = builder.havelegs;
		this.clas=builder.Class;
	}

	
	public String getClas() {
		return clas;
	}

	public void setClas(String clas) {
		this.clas = clas;
	}

	
	
	public String getHavelegs() {
		return havelegs;
	}

	public void setHavelegs(String havelegs) {
		this.havelegs = havelegs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGivebirth() {
		return givebirth;
	}

	public void setGivebirth(String givebirth) {
		this.givebirth = givebirth;
	}

	public String getCanfly() {
		return canfly;
	}

	public void setCanfly(String canfly) {
		this.canfly = canfly;
	}

	public String getLivewater() {
		return livewater;
	}

	public void setLivewater(String livewater) {
		this.livewater = livewater;
	}

	
	  public static class Builder{

		  String name;
		  String givebirth;
		  String canfly;
		  String livewater;
		  String havelegs;
		  String Class;
	        
	        

	      
	        public Builder(String name, String givebirth, String canfly,
				String livewater, String havelegs) {
			this.name = name;
			this.givebirth = givebirth;
			this.canfly = canfly;
			this.livewater = livewater;
			this.havelegs = havelegs;
		}

			public Builder setClass(String Class) {
				this.Class = Class;
				return this;
			}
			public contact build(){
	            return new contact(this);
	        }


	    }
	
}

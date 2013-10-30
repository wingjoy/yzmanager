package com.yz.manager.page;

public class PageSet {

	 private int currentpage=1;
	 
	 private int totalpage;
	 
	 private int totalsize;
	 
	 private int pagesize=10;

	
    public PageSet(){
    	
    }
    public PageSet(int totalsize,int pagesize){
    	
    	this.totalsize=totalsize;
    	this.pagesize=pagesize;
    	if(totalsize==0){
    		this.totalpage=1;
    	}else{
    		if(totalsize%pagesize==0){
    			this.totalpage=totalsize/pagesize;
    		}
    		else{
    			this.totalpage=(totalsize/pagesize)+1;
    		}
    	}
    	
    }
    
	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalsize) {
		if(totalsize==0){
    		this.totalpage=1;
    	}else{
    		if(totalsize%this.getPagesize()==0){
    			this.totalpage=totalsize/this.getPagesize();
    		}
    		else{
    			this.totalpage=(totalsize/this.getPagesize())+1;
    		}
    	}
		
	}

	public int getTotalsize() {
		return totalsize;
	}

	public void setTotalsize(int totalsize) {
		this.totalsize = totalsize;
	}

	public int getCurrentpage() {		
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage=currentpage;
		
	}
	
	public int searchCurrentPage(int pageindex){
		
		if(pageindex==0){
			this.setCurrentpage(1);
			
		}else{
        if(pageindex>=this.getTotalpage()){
					this.setCurrentpage(this.getTotalpage());
	       }
		   else this.setCurrentpage(pageindex);
		}
		return this.getCurrentpage();
	}
		
}

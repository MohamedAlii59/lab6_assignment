public class container implements Comparable<container> {
    private String conID;
    private String shName;
    private String lName;
    public String getConID(){
        return conID;
    }

    public void setConID(String conID) {
        this.conID = conID;
    }

    public String getShName() {
        return shName;
    }

    public void setShName(String shName) {
        this.shName = shName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public String toString() {
        return   "  <CONTAINER "+this.getConID()+">\n"
                +"      <SHORT-NAME>"+this.getShName()+"</SHORT-NAME>\n"
                +"      <LONG-NAME>"+this.getlName()+"</LONG-NAME>\n"
                +"  </CONTAINER>\n";
    }

    @Override
    public int compareTo(container o) {
        if(this.getShName().charAt(this.getShName().length()-1)>o.getShName().charAt(o.getShName().length()-1)){
            return 1;
        }else if(this.getShName().charAt(this.getShName().length()-1)< o.getShName().charAt(o.getShName().length()-1)){
            return -1;
        }else{
            return 0;
        }
    }
}

package AmazonTesting;

public class AmazonProduct {
	public int id;
	public String productName;
	//public String productCost;
	
AmazonProduct(int id, String productName, String productCost){
	this.id = id;
	this.productName = productName + "("+productCost+")";
	
}
	

}

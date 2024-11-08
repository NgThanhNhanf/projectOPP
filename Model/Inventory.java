package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import File.fileWork;
import Person.Customers;

public class Inventory implements fileWork {
    //mang luu 1 cai list cac san pham trong kho
    // product là lớp trừu tượng thì có dùng như vầy được hay không
    private static HashMap<Product, Integer> listInventory = new HashMap<>();
    public Inventory(){}
    // Chỉnh phương thức thành static
    public static HashMap<Product, Integer> getListInventory() {
        return listInventory;
    }

    // them so luong ton kho cua san pham vao kho hang
    public static void addInventory(Product product, int quanlity){
        listInventory.put(product, listInventory.getOrDefault(product, 0) + quanlity);
        System.out.println("da them " + listInventory.values() + " san pham");
    }
    //xoa bot di so luong ton kho cua san pham vao kho hang
    public static void deleteInventory(Product product, int quanlity){
        if(quanlity > 0){
            listInventory.put(product, listInventory.getOrDefault(product, 0) + (-quanlity));
            System.out.println("da bot di"  + listInventory.values() + "san pham");
        }
    }

    public static void removeInventory(String productName){
        for(Product product : listInventory.keySet()){
            if(product.getProductName().equals(productName)){
                listInventory.remove(product);
            }else {
                System.out.println("khong tim thay san pham trong kho"); break;
            }
        }
        System.out.println("Xoa san pham thanh cong");
    }

    public static void display(){
        for(Product product : listInventory.keySet()) {
            product.displayInfor();
            System.out.println("so luong ton:" + listInventory.get(product));
            System.out.println("----------------");
        }
    }

    //tính tổng giá trị các sản phẩm trong kho hàng
    public static double totalPrice(){
        double total = 0;
        for(Product product : listInventory.keySet()){
            // tổng = giá tiền của 1 sản phẩm(bất kì) * số lượng sản phẩm đó trong kho
            total += product.getPrice() * listInventory.get(product);
        }
        //trả về tổng của tất cả sản phẩm
        return total;
    }

    // Phương thức tìm sản phẩm theo ID
    public static Product getProductByID(int productID) {
        for(Product product : listInventory.keySet()){
            if(product.getProductID() == productID){
                return product;
            }
        }
        return null;
    }
    
    public static boolean findProduct(String productName){
        for(Product product : listInventory.keySet()){
            if(product.getProductName().equals(productName)){
                return true;
            }
        }
        return false;
    }

    public static Product getProductByName(String productName){
        for(Product product : listInventory.keySet()){
            if(product.getProductName().equals(productName)){
                return product;
            }
        }
        return null;
    }
    @Override
    public void readFile() throws FileNotFoundException {
        // File myFile = new File("D:\\Study\\OOP\\projectOPP\\Model\\clothingData.txt");
        File myFile = new File("D:\\Java\\Nhom14\\OOP-hanh\\DoAnOOP\\Project\\Model\\clothingData.txt");
        Scanner scf = new Scanner(myFile);
        while(scf.hasNextLine()) {
            String line = scf.nextLine();
            String [] arrstr = line.split("\\|");
            Clothing newClothing = new Clothing(Integer.parseInt(arrstr[0]), arrstr[1], Double.parseDouble(arrstr[2]), arrstr[3], arrstr[4]);
            Inventory.addInventory(newClothing, Integer.parseInt(arrstr[5]));
        }
        scf.close();
        // myFile = new File("D:\\Study\\OOP\\projectOPP\\Model\\shoesData.txt");
        myFile = new File("D:\\Java\\Nhom14\\OOP-hanh\\DoAnOOP\\Project\\Model\\shoesData.txt");
        scf = new Scanner(myFile);
        while(scf.hasNextLine()) {
            String line = scf.nextLine();
            String [] arrstr = line.split("\\|");
            Shoes newShoes = new Shoes(Integer.parseInt(arrstr[0]), arrstr[1], Double.parseDouble(arrstr[2]), Integer.parseInt(arrstr[3]), arrstr[4]);
            Inventory.addInventory(newShoes, Integer.parseInt(arrstr[5]));
        }
        scf.close();
    }
    @Override
    public void writeFile() throws IOException {
        // FileWriter myFileC = new FileWriter("D:\\Study\\OOP\\projectOPP\\Model\\clothingData.txt");
        // FileWriter myFileS = new FileWriter("D:\\Study\\OOP\\projectOPP\\Model\\shoesData.txt");

        FileWriter myFileC = new FileWriter("D:\\Java\\Nhom14\\OOP-hanh\\DoAnOOP\\Project\\Model\\clothingData.txt");
        FileWriter myFileS = new FileWriter("D:\\Java\\Nhom14\\OOP-hanh\\DoAnOOP\\Project\\Model\\shoesData.txt");
        for (Product cur : Inventory.getListInventory().keySet()) {
            if(cur instanceof Clothing) {
                Clothing tmp = (Clothing)cur;
                myFileC.write(tmp.getProductID() + "|" + tmp.getProductName() + "|" + tmp.getPrice() + "|" + tmp.getSize() + "|" + tmp.getMaterial() + "|" + Inventory.getListInventory().get(cur) + '\n');
            } else {
                Shoes tmp = (Shoes)cur;
                myFileS.write(tmp.getProductID() + "|" + tmp.getProductName() + "|" + tmp.getPrice() + "|" + tmp.getSize() + "|" + tmp.getColor() + "|" + Inventory.getListInventory().get(cur) + '\n');
            }
        }
        myFileC.close();
        myFileS.close();
    }

    public static void fileInit() throws FileNotFoundException {
        Inventory inventory = new Inventory();
        inventory.readFile();
    }

    public static void fileClose() throws IOException {
        Inventory inventory = new Inventory();
        inventory.writeFile();
    }
}
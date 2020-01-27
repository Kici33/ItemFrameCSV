package me.kici33.ItemFrame.objects;

public class ShopItem {

    private int ID;
    private byte data;
    private boolean buyDefined;
    private String buyPrice;
    private String buyAmount;
    private boolean sellDefined;
    private String sellPrice;
    private String sellAmount;

    public ShopItem(String[] csv) {
        String[] data = csv[1].split(":");
        this.ID = Integer.parseInt(data[0]);
        this.data = Byte.parseByte(data[1]);
        this.buyPrice = csv[2];
        this.buyAmount = csv[3];
        this.sellPrice = null;
        this.sellAmount = null;
        if(csv.length > 4) {
            this.sellPrice = csv[4];
            this.sellAmount = csv[5];
        }
        this.buyDefined = (buyPrice != null && buyAmount != null);
        this.sellDefined = (sellAmount != null &&  sellPrice != null);
    }

    public int getData() {
        return data;
    }

    public boolean isBuyDefined() {
        return buyDefined;
    }

    public boolean isSellDefined() {
        return sellDefined;
    }

    public String getBuyAmount() {
        return buyAmount;
    }

    public String getBuyPrice() {
        return buyPrice;
    }

    public int getID() {
        return ID;
    }

    public String getSellAmount() {
        return sellAmount;
    }

    public String getSellPrice() {
        return sellPrice;
    }
}

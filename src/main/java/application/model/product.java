package application.model;

public interface product {
    String getDescription();

    void setDescription(String description);

    String getName();

    void setName(String name);

    Double getPrice();

    void setPrice(Double price);

    Integer getId();

    void setId(Long iD);

    String getSupplier();

    void setSupplier(String supplier);
}

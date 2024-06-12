/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.sam.infrastructure.kafka.system.product.avro.model;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class ProductCreatedAvroModel extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -2351073845351018820L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ProductCreatedAvroModel\",\"namespace\":\"com.sam.infrastructure.kafka.system.product.avro.model\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"sagaId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"name\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"description\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"price\",\"type\":{\"type\":\"bytes\",\"logicalType\":\"decimal\",\"precision\":10,\"scale\":2}},{\"name\":\"createdAt\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}},{\"name\":\"productStatus\",\"type\":{\"type\":\"enum\",\"name\":\"ProductStatus\",\"symbols\":[\"PENDING\",\"AVAILABLE\",\"PHASING_OUT\",\"NOT_AVAILABLE\"]}},{\"name\":\"productCategory\",\"type\":{\"type\":\"enum\",\"name\":\"ProductCategory\",\"symbols\":[\"ELECTRONIC\",\"SPORTS\",\"HOME_APPLIANCES\"]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();
  static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
    MODEL$.addLogicalTypeConversion(new org.apache.avro.Conversions.DecimalConversion());
  }

  private static final BinaryMessageEncoder<ProductCreatedAvroModel> ENCODER =
      new BinaryMessageEncoder<ProductCreatedAvroModel>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<ProductCreatedAvroModel> DECODER =
      new BinaryMessageDecoder<ProductCreatedAvroModel>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<ProductCreatedAvroModel> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<ProductCreatedAvroModel> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<ProductCreatedAvroModel> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<ProductCreatedAvroModel>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this ProductCreatedAvroModel to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a ProductCreatedAvroModel from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a ProductCreatedAvroModel instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static ProductCreatedAvroModel fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.String id;
  private java.lang.String sagaId;
  private java.lang.String name;
  private java.lang.String description;
  private java.math.BigDecimal price;
  private java.time.Instant createdAt;
  private com.sam.infrastructure.kafka.system.product.avro.model.ProductStatus productStatus;
  private com.sam.infrastructure.kafka.system.product.avro.model.ProductCategory productCategory;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ProductCreatedAvroModel() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param sagaId The new value for sagaId
   * @param name The new value for name
   * @param description The new value for description
   * @param price The new value for price
   * @param createdAt The new value for createdAt
   * @param productStatus The new value for productStatus
   * @param productCategory The new value for productCategory
   */
  public ProductCreatedAvroModel(java.lang.String id, java.lang.String sagaId, java.lang.String name, java.lang.String description, java.math.BigDecimal price, java.time.Instant createdAt, com.sam.infrastructure.kafka.system.product.avro.model.ProductStatus productStatus, com.sam.infrastructure.kafka.system.product.avro.model.ProductCategory productCategory) {
    this.id = id;
    this.sagaId = sagaId;
    this.name = name;
    this.description = description;
    this.price = price;
    this.createdAt = createdAt.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
    this.productStatus = productStatus;
    this.productCategory = productCategory;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return sagaId;
    case 2: return name;
    case 3: return description;
    case 4: return price;
    case 5: return createdAt;
    case 6: return productStatus;
    case 7: return productCategory;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      null,
      null,
      null,
      null,
      new org.apache.avro.Conversions.DecimalConversion(),
      new org.apache.avro.data.TimeConversions.TimestampMillisConversion(),
      null,
      null,
      null
  };

  @Override
  public org.apache.avro.Conversion<?> getConversion(int field) {
    return conversions[field];
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = value$ != null ? value$.toString() : null; break;
    case 1: sagaId = value$ != null ? value$.toString() : null; break;
    case 2: name = value$ != null ? value$.toString() : null; break;
    case 3: description = value$ != null ? value$.toString() : null; break;
    case 4: price = (java.math.BigDecimal)value$; break;
    case 5: createdAt = (java.time.Instant)value$; break;
    case 6: productStatus = (com.sam.infrastructure.kafka.system.product.avro.model.ProductStatus)value$; break;
    case 7: productCategory = (com.sam.infrastructure.kafka.system.product.avro.model.ProductCategory)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.String getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.String value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'sagaId' field.
   * @return The value of the 'sagaId' field.
   */
  public java.lang.String getSagaId() {
    return sagaId;
  }


  /**
   * Sets the value of the 'sagaId' field.
   * @param value the value to set.
   */
  public void setSagaId(java.lang.String value) {
    this.sagaId = value;
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.String getName() {
    return name;
  }


  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.String value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'description' field.
   * @return The value of the 'description' field.
   */
  public java.lang.String getDescription() {
    return description;
  }


  /**
   * Sets the value of the 'description' field.
   * @param value the value to set.
   */
  public void setDescription(java.lang.String value) {
    this.description = value;
  }

  /**
   * Gets the value of the 'price' field.
   * @return The value of the 'price' field.
   */
  public java.math.BigDecimal getPrice() {
    return price;
  }


  /**
   * Sets the value of the 'price' field.
   * @param value the value to set.
   */
  public void setPrice(java.math.BigDecimal value) {
    this.price = value;
  }

  /**
   * Gets the value of the 'createdAt' field.
   * @return The value of the 'createdAt' field.
   */
  public java.time.Instant getCreatedAt() {
    return createdAt;
  }


  /**
   * Sets the value of the 'createdAt' field.
   * @param value the value to set.
   */
  public void setCreatedAt(java.time.Instant value) {
    this.createdAt = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  /**
   * Gets the value of the 'productStatus' field.
   * @return The value of the 'productStatus' field.
   */
  public com.sam.infrastructure.kafka.system.product.avro.model.ProductStatus getProductStatus() {
    return productStatus;
  }


  /**
   * Sets the value of the 'productStatus' field.
   * @param value the value to set.
   */
  public void setProductStatus(com.sam.infrastructure.kafka.system.product.avro.model.ProductStatus value) {
    this.productStatus = value;
  }

  /**
   * Gets the value of the 'productCategory' field.
   * @return The value of the 'productCategory' field.
   */
  public com.sam.infrastructure.kafka.system.product.avro.model.ProductCategory getProductCategory() {
    return productCategory;
  }


  /**
   * Sets the value of the 'productCategory' field.
   * @param value the value to set.
   */
  public void setProductCategory(com.sam.infrastructure.kafka.system.product.avro.model.ProductCategory value) {
    this.productCategory = value;
  }

  /**
   * Creates a new ProductCreatedAvroModel RecordBuilder.
   * @return A new ProductCreatedAvroModel RecordBuilder
   */
  public static com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel.Builder newBuilder() {
    return new com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel.Builder();
  }

  /**
   * Creates a new ProductCreatedAvroModel RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ProductCreatedAvroModel RecordBuilder
   */
  public static com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel.Builder newBuilder(com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel.Builder other) {
    if (other == null) {
      return new com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel.Builder();
    } else {
      return new com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel.Builder(other);
    }
  }

  /**
   * Creates a new ProductCreatedAvroModel RecordBuilder by copying an existing ProductCreatedAvroModel instance.
   * @param other The existing instance to copy.
   * @return A new ProductCreatedAvroModel RecordBuilder
   */
  public static com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel.Builder newBuilder(com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel other) {
    if (other == null) {
      return new com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel.Builder();
    } else {
      return new com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel.Builder(other);
    }
  }

  /**
   * RecordBuilder for ProductCreatedAvroModel instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ProductCreatedAvroModel>
    implements org.apache.avro.data.RecordBuilder<ProductCreatedAvroModel> {

    private java.lang.String id;
    private java.lang.String sagaId;
    private java.lang.String name;
    private java.lang.String description;
    private java.math.BigDecimal price;
    private java.time.Instant createdAt;
    private com.sam.infrastructure.kafka.system.product.avro.model.ProductStatus productStatus;
    private com.sam.infrastructure.kafka.system.product.avro.model.ProductCategory productCategory;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.sagaId)) {
        this.sagaId = data().deepCopy(fields()[1].schema(), other.sagaId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.name)) {
        this.name = data().deepCopy(fields()[2].schema(), other.name);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.description)) {
        this.description = data().deepCopy(fields()[3].schema(), other.description);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.price)) {
        this.price = data().deepCopy(fields()[4].schema(), other.price);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[5].schema(), other.createdAt);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.productStatus)) {
        this.productStatus = data().deepCopy(fields()[6].schema(), other.productStatus);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
      if (isValidValue(fields()[7], other.productCategory)) {
        this.productCategory = data().deepCopy(fields()[7].schema(), other.productCategory);
        fieldSetFlags()[7] = other.fieldSetFlags()[7];
      }
    }

    /**
     * Creates a Builder by copying an existing ProductCreatedAvroModel instance
     * @param other The existing instance to copy.
     */
    private Builder(com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.sagaId)) {
        this.sagaId = data().deepCopy(fields()[1].schema(), other.sagaId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.name)) {
        this.name = data().deepCopy(fields()[2].schema(), other.name);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.description)) {
        this.description = data().deepCopy(fields()[3].schema(), other.description);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.price)) {
        this.price = data().deepCopy(fields()[4].schema(), other.price);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[5].schema(), other.createdAt);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.productStatus)) {
        this.productStatus = data().deepCopy(fields()[6].schema(), other.productStatus);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.productCategory)) {
        this.productCategory = data().deepCopy(fields()[7].schema(), other.productCategory);
        fieldSetFlags()[7] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.String getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel.Builder setId(java.lang.String value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'sagaId' field.
      * @return The value.
      */
    public java.lang.String getSagaId() {
      return sagaId;
    }


    /**
      * Sets the value of the 'sagaId' field.
      * @param value The value of 'sagaId'.
      * @return This builder.
      */
    public com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel.Builder setSagaId(java.lang.String value) {
      validate(fields()[1], value);
      this.sagaId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'sagaId' field has been set.
      * @return True if the 'sagaId' field has been set, false otherwise.
      */
    public boolean hasSagaId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'sagaId' field.
      * @return This builder.
      */
    public com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel.Builder clearSagaId() {
      sagaId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.String getName() {
      return name;
    }


    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel.Builder setName(java.lang.String value) {
      validate(fields()[2], value);
      this.name = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel.Builder clearName() {
      name = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'description' field.
      * @return The value.
      */
    public java.lang.String getDescription() {
      return description;
    }


    /**
      * Sets the value of the 'description' field.
      * @param value The value of 'description'.
      * @return This builder.
      */
    public com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel.Builder setDescription(java.lang.String value) {
      validate(fields()[3], value);
      this.description = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'description' field has been set.
      * @return True if the 'description' field has been set, false otherwise.
      */
    public boolean hasDescription() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'description' field.
      * @return This builder.
      */
    public com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel.Builder clearDescription() {
      description = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'price' field.
      * @return The value.
      */
    public java.math.BigDecimal getPrice() {
      return price;
    }


    /**
      * Sets the value of the 'price' field.
      * @param value The value of 'price'.
      * @return This builder.
      */
    public com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel.Builder setPrice(java.math.BigDecimal value) {
      validate(fields()[4], value);
      this.price = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'price' field has been set.
      * @return True if the 'price' field has been set, false otherwise.
      */
    public boolean hasPrice() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'price' field.
      * @return This builder.
      */
    public com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel.Builder clearPrice() {
      price = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'createdAt' field.
      * @return The value.
      */
    public java.time.Instant getCreatedAt() {
      return createdAt;
    }


    /**
      * Sets the value of the 'createdAt' field.
      * @param value The value of 'createdAt'.
      * @return This builder.
      */
    public com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel.Builder setCreatedAt(java.time.Instant value) {
      validate(fields()[5], value);
      this.createdAt = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'createdAt' field has been set.
      * @return True if the 'createdAt' field has been set, false otherwise.
      */
    public boolean hasCreatedAt() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'createdAt' field.
      * @return This builder.
      */
    public com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel.Builder clearCreatedAt() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'productStatus' field.
      * @return The value.
      */
    public com.sam.infrastructure.kafka.system.product.avro.model.ProductStatus getProductStatus() {
      return productStatus;
    }


    /**
      * Sets the value of the 'productStatus' field.
      * @param value The value of 'productStatus'.
      * @return This builder.
      */
    public com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel.Builder setProductStatus(com.sam.infrastructure.kafka.system.product.avro.model.ProductStatus value) {
      validate(fields()[6], value);
      this.productStatus = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'productStatus' field has been set.
      * @return True if the 'productStatus' field has been set, false otherwise.
      */
    public boolean hasProductStatus() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'productStatus' field.
      * @return This builder.
      */
    public com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel.Builder clearProductStatus() {
      productStatus = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'productCategory' field.
      * @return The value.
      */
    public com.sam.infrastructure.kafka.system.product.avro.model.ProductCategory getProductCategory() {
      return productCategory;
    }


    /**
      * Sets the value of the 'productCategory' field.
      * @param value The value of 'productCategory'.
      * @return This builder.
      */
    public com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel.Builder setProductCategory(com.sam.infrastructure.kafka.system.product.avro.model.ProductCategory value) {
      validate(fields()[7], value);
      this.productCategory = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'productCategory' field has been set.
      * @return True if the 'productCategory' field has been set, false otherwise.
      */
    public boolean hasProductCategory() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'productCategory' field.
      * @return This builder.
      */
    public com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel.Builder clearProductCategory() {
      productCategory = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ProductCreatedAvroModel build() {
      try {
        ProductCreatedAvroModel record = new ProductCreatedAvroModel();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.String) defaultValue(fields()[0]);
        record.sagaId = fieldSetFlags()[1] ? this.sagaId : (java.lang.String) defaultValue(fields()[1]);
        record.name = fieldSetFlags()[2] ? this.name : (java.lang.String) defaultValue(fields()[2]);
        record.description = fieldSetFlags()[3] ? this.description : (java.lang.String) defaultValue(fields()[3]);
        record.price = fieldSetFlags()[4] ? this.price : (java.math.BigDecimal) defaultValue(fields()[4]);
        record.createdAt = fieldSetFlags()[5] ? this.createdAt : (java.time.Instant) defaultValue(fields()[5]);
        record.productStatus = fieldSetFlags()[6] ? this.productStatus : (com.sam.infrastructure.kafka.system.product.avro.model.ProductStatus) defaultValue(fields()[6]);
        record.productCategory = fieldSetFlags()[7] ? this.productCategory : (com.sam.infrastructure.kafka.system.product.avro.model.ProductCategory) defaultValue(fields()[7]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<ProductCreatedAvroModel>
    WRITER$ = (org.apache.avro.io.DatumWriter<ProductCreatedAvroModel>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<ProductCreatedAvroModel>
    READER$ = (org.apache.avro.io.DatumReader<ProductCreatedAvroModel>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










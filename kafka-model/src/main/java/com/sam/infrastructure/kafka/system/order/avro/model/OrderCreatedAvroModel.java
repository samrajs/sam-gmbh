/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.sam.infrastructure.kafka.system.order.avro.model;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class OrderCreatedAvroModel extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 3509974772894727647L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"OrderCreatedAvroModel\",\"namespace\":\"com.sam.infrastructure.kafka.system.order.avro.model\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"customerId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"orderAmount\",\"type\":{\"type\":\"bytes\",\"logicalType\":\"decimal\",\"precision\":10,\"scale\":2}},{\"name\":\"createdAt\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();
  static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
    MODEL$.addLogicalTypeConversion(new org.apache.avro.Conversions.DecimalConversion());
  }

  private static final BinaryMessageEncoder<OrderCreatedAvroModel> ENCODER =
      new BinaryMessageEncoder<OrderCreatedAvroModel>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<OrderCreatedAvroModel> DECODER =
      new BinaryMessageDecoder<OrderCreatedAvroModel>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<OrderCreatedAvroModel> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<OrderCreatedAvroModel> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<OrderCreatedAvroModel> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<OrderCreatedAvroModel>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this OrderCreatedAvroModel to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a OrderCreatedAvroModel from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a OrderCreatedAvroModel instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static OrderCreatedAvroModel fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.String id;
  private java.lang.String customerId;
  private java.math.BigDecimal orderAmount;
  private java.time.Instant createdAt;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public OrderCreatedAvroModel() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param customerId The new value for customerId
   * @param orderAmount The new value for orderAmount
   * @param createdAt The new value for createdAt
   */
  public OrderCreatedAvroModel(java.lang.String id, java.lang.String customerId, java.math.BigDecimal orderAmount, java.time.Instant createdAt) {
    this.id = id;
    this.customerId = customerId;
    this.orderAmount = orderAmount;
    this.createdAt = createdAt.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return customerId;
    case 2: return orderAmount;
    case 3: return createdAt;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      null,
      null,
      new org.apache.avro.Conversions.DecimalConversion(),
      new org.apache.avro.data.TimeConversions.TimestampMillisConversion(),
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
    case 1: customerId = value$ != null ? value$.toString() : null; break;
    case 2: orderAmount = (java.math.BigDecimal)value$; break;
    case 3: createdAt = (java.time.Instant)value$; break;
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
   * Gets the value of the 'customerId' field.
   * @return The value of the 'customerId' field.
   */
  public java.lang.String getCustomerId() {
    return customerId;
  }


  /**
   * Sets the value of the 'customerId' field.
   * @param value the value to set.
   */
  public void setCustomerId(java.lang.String value) {
    this.customerId = value;
  }

  /**
   * Gets the value of the 'orderAmount' field.
   * @return The value of the 'orderAmount' field.
   */
  public java.math.BigDecimal getOrderAmount() {
    return orderAmount;
  }


  /**
   * Sets the value of the 'orderAmount' field.
   * @param value the value to set.
   */
  public void setOrderAmount(java.math.BigDecimal value) {
    this.orderAmount = value;
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
   * Creates a new OrderCreatedAvroModel RecordBuilder.
   * @return A new OrderCreatedAvroModel RecordBuilder
   */
  public static com.sam.infrastructure.kafka.system.order.avro.model.OrderCreatedAvroModel.Builder newBuilder() {
    return new com.sam.infrastructure.kafka.system.order.avro.model.OrderCreatedAvroModel.Builder();
  }

  /**
   * Creates a new OrderCreatedAvroModel RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new OrderCreatedAvroModel RecordBuilder
   */
  public static com.sam.infrastructure.kafka.system.order.avro.model.OrderCreatedAvroModel.Builder newBuilder(com.sam.infrastructure.kafka.system.order.avro.model.OrderCreatedAvroModel.Builder other) {
    if (other == null) {
      return new com.sam.infrastructure.kafka.system.order.avro.model.OrderCreatedAvroModel.Builder();
    } else {
      return new com.sam.infrastructure.kafka.system.order.avro.model.OrderCreatedAvroModel.Builder(other);
    }
  }

  /**
   * Creates a new OrderCreatedAvroModel RecordBuilder by copying an existing OrderCreatedAvroModel instance.
   * @param other The existing instance to copy.
   * @return A new OrderCreatedAvroModel RecordBuilder
   */
  public static com.sam.infrastructure.kafka.system.order.avro.model.OrderCreatedAvroModel.Builder newBuilder(com.sam.infrastructure.kafka.system.order.avro.model.OrderCreatedAvroModel other) {
    if (other == null) {
      return new com.sam.infrastructure.kafka.system.order.avro.model.OrderCreatedAvroModel.Builder();
    } else {
      return new com.sam.infrastructure.kafka.system.order.avro.model.OrderCreatedAvroModel.Builder(other);
    }
  }

  /**
   * RecordBuilder for OrderCreatedAvroModel instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<OrderCreatedAvroModel>
    implements org.apache.avro.data.RecordBuilder<OrderCreatedAvroModel> {

    private java.lang.String id;
    private java.lang.String customerId;
    private java.math.BigDecimal orderAmount;
    private java.time.Instant createdAt;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.sam.infrastructure.kafka.system.order.avro.model.OrderCreatedAvroModel.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.customerId)) {
        this.customerId = data().deepCopy(fields()[1].schema(), other.customerId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.orderAmount)) {
        this.orderAmount = data().deepCopy(fields()[2].schema(), other.orderAmount);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[3].schema(), other.createdAt);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing OrderCreatedAvroModel instance
     * @param other The existing instance to copy.
     */
    private Builder(com.sam.infrastructure.kafka.system.order.avro.model.OrderCreatedAvroModel other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.customerId)) {
        this.customerId = data().deepCopy(fields()[1].schema(), other.customerId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.orderAmount)) {
        this.orderAmount = data().deepCopy(fields()[2].schema(), other.orderAmount);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[3].schema(), other.createdAt);
        fieldSetFlags()[3] = true;
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
    public com.sam.infrastructure.kafka.system.order.avro.model.OrderCreatedAvroModel.Builder setId(java.lang.String value) {
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
    public com.sam.infrastructure.kafka.system.order.avro.model.OrderCreatedAvroModel.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'customerId' field.
      * @return The value.
      */
    public java.lang.String getCustomerId() {
      return customerId;
    }


    /**
      * Sets the value of the 'customerId' field.
      * @param value The value of 'customerId'.
      * @return This builder.
      */
    public com.sam.infrastructure.kafka.system.order.avro.model.OrderCreatedAvroModel.Builder setCustomerId(java.lang.String value) {
      validate(fields()[1], value);
      this.customerId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'customerId' field has been set.
      * @return True if the 'customerId' field has been set, false otherwise.
      */
    public boolean hasCustomerId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'customerId' field.
      * @return This builder.
      */
    public com.sam.infrastructure.kafka.system.order.avro.model.OrderCreatedAvroModel.Builder clearCustomerId() {
      customerId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'orderAmount' field.
      * @return The value.
      */
    public java.math.BigDecimal getOrderAmount() {
      return orderAmount;
    }


    /**
      * Sets the value of the 'orderAmount' field.
      * @param value The value of 'orderAmount'.
      * @return This builder.
      */
    public com.sam.infrastructure.kafka.system.order.avro.model.OrderCreatedAvroModel.Builder setOrderAmount(java.math.BigDecimal value) {
      validate(fields()[2], value);
      this.orderAmount = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'orderAmount' field has been set.
      * @return True if the 'orderAmount' field has been set, false otherwise.
      */
    public boolean hasOrderAmount() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'orderAmount' field.
      * @return This builder.
      */
    public com.sam.infrastructure.kafka.system.order.avro.model.OrderCreatedAvroModel.Builder clearOrderAmount() {
      orderAmount = null;
      fieldSetFlags()[2] = false;
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
    public com.sam.infrastructure.kafka.system.order.avro.model.OrderCreatedAvroModel.Builder setCreatedAt(java.time.Instant value) {
      validate(fields()[3], value);
      this.createdAt = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'createdAt' field has been set.
      * @return True if the 'createdAt' field has been set, false otherwise.
      */
    public boolean hasCreatedAt() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'createdAt' field.
      * @return This builder.
      */
    public com.sam.infrastructure.kafka.system.order.avro.model.OrderCreatedAvroModel.Builder clearCreatedAt() {
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public OrderCreatedAvroModel build() {
      try {
        OrderCreatedAvroModel record = new OrderCreatedAvroModel();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.String) defaultValue(fields()[0]);
        record.customerId = fieldSetFlags()[1] ? this.customerId : (java.lang.String) defaultValue(fields()[1]);
        record.orderAmount = fieldSetFlags()[2] ? this.orderAmount : (java.math.BigDecimal) defaultValue(fields()[2]);
        record.createdAt = fieldSetFlags()[3] ? this.createdAt : (java.time.Instant) defaultValue(fields()[3]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<OrderCreatedAvroModel>
    WRITER$ = (org.apache.avro.io.DatumWriter<OrderCreatedAvroModel>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<OrderCreatedAvroModel>
    READER$ = (org.apache.avro.io.DatumReader<OrderCreatedAvroModel>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










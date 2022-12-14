/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package io.confluent.developer.spring.model;

import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;

/** A weather reading. */
@org.apache.avro.specific.AvroGenerated
public class Weather extends org.apache.avro.specific.SpecificRecordBase
		implements org.apache.avro.specific.SpecificRecord {
	private static final long serialVersionUID = 5221993721541780002L;

	public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse(
			"{\"type\":\"record\",\"name\":\"Weather\",\"namespace\":\"io.confluent.developer.spring.model\",\"doc\":\"A weather reading.\",\"fields\":[{\"name\":\"station\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"order\":\"ignore\"},{\"name\":\"time\",\"type\":\"long\"},{\"name\":\"temp\",\"type\":\"int\"}]}");

	public static org.apache.avro.Schema getClassSchema() {
		return SCHEMA$;
	}

	private static final SpecificData MODEL$ = new SpecificData();

	private static final BinaryMessageEncoder<Weather> ENCODER = new BinaryMessageEncoder<Weather>(MODEL$, SCHEMA$);

	private static final BinaryMessageDecoder<Weather> DECODER = new BinaryMessageDecoder<Weather>(MODEL$, SCHEMA$);

	/**
	 * Return the BinaryMessageEncoder instance used by this class.
	 * @return the message encoder used by this class
	 */
	public static BinaryMessageEncoder<Weather> getEncoder() {
		return ENCODER;
	}

	/**
	 * Return the BinaryMessageDecoder instance used by this class.
	 * @return the message decoder used by this class
	 */
	public static BinaryMessageDecoder<Weather> getDecoder() {
		return DECODER;
	}

	/**
	 * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
	 * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
	 * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
	 */
	public static BinaryMessageDecoder<Weather> createDecoder(SchemaStore resolver) {
		return new BinaryMessageDecoder<Weather>(MODEL$, SCHEMA$, resolver);
	}

	/**
	 * Serializes this Weather to a ByteBuffer.
	 * @return a buffer holding the serialized data for this instance
	 * @throws java.io.IOException if this instance could not be serialized
	 */
	public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
		return ENCODER.encode(this);
	}

	/**
	 * Deserializes a Weather from a ByteBuffer.
	 * @param b a byte buffer holding serialized data for an instance of this class
	 * @return a Weather instance decoded from the given buffer
	 * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
	 */
	public static Weather fromByteBuffer(java.nio.ByteBuffer b) throws java.io.IOException {
		return DECODER.decode(b);
	}

	private java.lang.String station;
	private long time;
	private int temp;

	/**
	 * Default constructor.  Note that this does not initialize fields
	 * to their default values from the schema.  If that is desired then
	 * one should use <code>newBuilder()</code>.
	 */
	public Weather() {
	}

	/**
	 * All-args constructor.
	 * @param station The new value for station
	 * @param time The new value for time
	 * @param temp The new value for temp
	 */
	public Weather(java.lang.String station, java.lang.Long time, java.lang.Integer temp) {
		this.station = station;
		this.time = time;
		this.temp = temp;
	}

	@Override
	public org.apache.avro.specific.SpecificData getSpecificData() {
		return MODEL$;
	}

	@Override
	public org.apache.avro.Schema getSchema() {
		return SCHEMA$;
	}

	// Used by DatumWriter.  Applications should not call.
	@Override
	public java.lang.Object get(int field$) {
		switch (field$) {
		case 0:
			return station;
		case 1:
			return time;
		case 2:
			return temp;
		default:
			throw new IndexOutOfBoundsException("Invalid index: " + field$);
		}
	}

	// Used by DatumReader.  Applications should not call.
	@Override
	@SuppressWarnings(value = "unchecked")
	public void put(int field$, java.lang.Object value$) {
		switch (field$) {
		case 0:
			station = value$ != null ? value$.toString() : null;
			break;
		case 1:
			time = (java.lang.Long) value$;
			break;
		case 2:
			temp = (java.lang.Integer) value$;
			break;
		default:
			throw new IndexOutOfBoundsException("Invalid index: " + field$);
		}
	}

	/**
	 * Gets the value of the 'station' field.
	 * @return The value of the 'station' field.
	 */
	public java.lang.String getStation() {
		return station;
	}

	/**
	 * Sets the value of the 'station' field.
	 * @param value the value to set.
	 */
	public void setStation(java.lang.String value) {
		this.station = value;
	}

	/**
	 * Gets the value of the 'time' field.
	 * @return The value of the 'time' field.
	 */
	public long getTime() {
		return time;
	}

	/**
	 * Sets the value of the 'time' field.
	 * @param value the value to set.
	 */
	public void setTime(long value) {
		this.time = value;
	}

	/**
	 * Gets the value of the 'temp' field.
	 * @return The value of the 'temp' field.
	 */
	public int getTemp() {
		return temp;
	}

	/**
	 * Sets the value of the 'temp' field.
	 * @param value the value to set.
	 */
	public void setTemp(int value) {
		this.temp = value;
	}

	/**
	 * Creates a new Weather RecordBuilder.
	 * @return A new Weather RecordBuilder
	 */
	public static io.confluent.developer.spring.model.Weather.Builder newBuilder() {
		return new io.confluent.developer.spring.model.Weather.Builder();
	}

	/**
	 * Creates a new Weather RecordBuilder by copying an existing Builder.
	 * @param other The existing builder to copy.
	 * @return A new Weather RecordBuilder
	 */
	public static io.confluent.developer.spring.model.Weather.Builder newBuilder(
			io.confluent.developer.spring.model.Weather.Builder other) {
		if (other == null) {
			return new io.confluent.developer.spring.model.Weather.Builder();
		} else {
			return new io.confluent.developer.spring.model.Weather.Builder(other);
		}
	}

	/**
	 * Creates a new Weather RecordBuilder by copying an existing Weather instance.
	 * @param other The existing instance to copy.
	 * @return A new Weather RecordBuilder
	 */
	public static io.confluent.developer.spring.model.Weather.Builder newBuilder(
			io.confluent.developer.spring.model.Weather other) {
		if (other == null) {
			return new io.confluent.developer.spring.model.Weather.Builder();
		} else {
			return new io.confluent.developer.spring.model.Weather.Builder(other);
		}
	}

	/**
	 * RecordBuilder for Weather instances.
	 */
	@org.apache.avro.specific.AvroGenerated
	public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Weather>
			implements org.apache.avro.data.RecordBuilder<Weather> {

		private java.lang.String station;
		private long time;
		private int temp;

		/** Creates a new Builder */
		private Builder() {
			super(SCHEMA$, MODEL$);
		}

		/**
		 * Creates a Builder by copying an existing Builder.
		 * @param other The existing Builder to copy.
		 */
		private Builder(io.confluent.developer.spring.model.Weather.Builder other) {
			super(other);
			if (isValidValue(fields()[0], other.station)) {
				this.station = data().deepCopy(fields()[0].schema(), other.station);
				fieldSetFlags()[0] = other.fieldSetFlags()[0];
			}
			if (isValidValue(fields()[1], other.time)) {
				this.time = data().deepCopy(fields()[1].schema(), other.time);
				fieldSetFlags()[1] = other.fieldSetFlags()[1];
			}
			if (isValidValue(fields()[2], other.temp)) {
				this.temp = data().deepCopy(fields()[2].schema(), other.temp);
				fieldSetFlags()[2] = other.fieldSetFlags()[2];
			}
		}

		/**
		 * Creates a Builder by copying an existing Weather instance
		 * @param other The existing instance to copy.
		 */
		private Builder(io.confluent.developer.spring.model.Weather other) {
			super(SCHEMA$, MODEL$);
			if (isValidValue(fields()[0], other.station)) {
				this.station = data().deepCopy(fields()[0].schema(), other.station);
				fieldSetFlags()[0] = true;
			}
			if (isValidValue(fields()[1], other.time)) {
				this.time = data().deepCopy(fields()[1].schema(), other.time);
				fieldSetFlags()[1] = true;
			}
			if (isValidValue(fields()[2], other.temp)) {
				this.temp = data().deepCopy(fields()[2].schema(), other.temp);
				fieldSetFlags()[2] = true;
			}
		}

		/**
		  * Gets the value of the 'station' field.
		  * @return The value.
		  */
		public java.lang.String getStation() {
			return station;
		}

		/**
		  * Sets the value of the 'station' field.
		  * @param value The value of 'station'.
		  * @return This builder.
		  */
		public io.confluent.developer.spring.model.Weather.Builder setStation(java.lang.String value) {
			validate(fields()[0], value);
			this.station = value;
			fieldSetFlags()[0] = true;
			return this;
		}

		/**
		  * Checks whether the 'station' field has been set.
		  * @return True if the 'station' field has been set, false otherwise.
		  */
		public boolean hasStation() {
			return fieldSetFlags()[0];
		}

		/**
		  * Clears the value of the 'station' field.
		  * @return This builder.
		  */
		public io.confluent.developer.spring.model.Weather.Builder clearStation() {
			station = null;
			fieldSetFlags()[0] = false;
			return this;
		}

		/**
		  * Gets the value of the 'time' field.
		  * @return The value.
		  */
		public long getTime() {
			return time;
		}

		/**
		  * Sets the value of the 'time' field.
		  * @param value The value of 'time'.
		  * @return This builder.
		  */
		public io.confluent.developer.spring.model.Weather.Builder setTime(long value) {
			validate(fields()[1], value);
			this.time = value;
			fieldSetFlags()[1] = true;
			return this;
		}

		/**
		  * Checks whether the 'time' field has been set.
		  * @return True if the 'time' field has been set, false otherwise.
		  */
		public boolean hasTime() {
			return fieldSetFlags()[1];
		}

		/**
		  * Clears the value of the 'time' field.
		  * @return This builder.
		  */
		public io.confluent.developer.spring.model.Weather.Builder clearTime() {
			fieldSetFlags()[1] = false;
			return this;
		}

		/**
		  * Gets the value of the 'temp' field.
		  * @return The value.
		  */
		public int getTemp() {
			return temp;
		}

		/**
		  * Sets the value of the 'temp' field.
		  * @param value The value of 'temp'.
		  * @return This builder.
		  */
		public io.confluent.developer.spring.model.Weather.Builder setTemp(int value) {
			validate(fields()[2], value);
			this.temp = value;
			fieldSetFlags()[2] = true;
			return this;
		}

		/**
		  * Checks whether the 'temp' field has been set.
		  * @return True if the 'temp' field has been set, false otherwise.
		  */
		public boolean hasTemp() {
			return fieldSetFlags()[2];
		}

		/**
		  * Clears the value of the 'temp' field.
		  * @return This builder.
		  */
		public io.confluent.developer.spring.model.Weather.Builder clearTemp() {
			fieldSetFlags()[2] = false;
			return this;
		}

		@Override
		@SuppressWarnings("unchecked")
		public Weather build() {
			try {
				Weather record = new Weather();
				record.station = fieldSetFlags()[0] ? this.station : (java.lang.String) defaultValue(fields()[0]);
				record.time = fieldSetFlags()[1] ? this.time : (java.lang.Long) defaultValue(fields()[1]);
				record.temp = fieldSetFlags()[2] ? this.temp : (java.lang.Integer) defaultValue(fields()[2]);
				return record;
			} catch (org.apache.avro.AvroMissingFieldException e) {
				throw e;
			} catch (java.lang.Exception e) {
				throw new org.apache.avro.AvroRuntimeException(e);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static final org.apache.avro.io.DatumWriter<Weather> WRITER$ = MODEL$.createDatumWriter(SCHEMA$);

	@Override
	public void writeExternal(java.io.ObjectOutput out) throws java.io.IOException {
		WRITER$.write(this, SpecificData.getEncoder(out));
	}

	@SuppressWarnings("unchecked")
	private static final org.apache.avro.io.DatumReader<Weather> READER$ = MODEL$.createDatumReader(SCHEMA$);

	@Override
	public void readExternal(java.io.ObjectInput in) throws java.io.IOException {
		READER$.read(this, SpecificData.getDecoder(in));
	}

	@Override
	protected boolean hasCustomCoders() {
		return true;
	}

	@Override
	public void customEncode(org.apache.avro.io.Encoder out) throws java.io.IOException {
		out.writeString(this.station);

		out.writeLong(this.time);

		out.writeInt(this.temp);

	}

	@Override
	public void customDecode(org.apache.avro.io.ResolvingDecoder in) throws java.io.IOException {
		org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
		if (fieldOrder == null) {
			this.station = in.readString();

			this.time = in.readLong();

			this.temp = in.readInt();

		} else {
			for (int i = 0; i < 3; i++) {
				switch (fieldOrder[i].pos()) {
				case 0:
					this.station = in.readString();
					break;

				case 1:
					this.time = in.readLong();
					break;

				case 2:
					this.temp = in.readInt();
					break;

				default:
					throw new java.io.IOException("Corrupt ResolvingDecoder.");
				}
			}
		}
	}
}

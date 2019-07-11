package org.cnt.java.classfile.bytecode.constantpool.entry;

import org.cnt.java.classfile.bytecode.constantpool.Byte4;
import org.cnt.java.utils.Byter;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class ConstantDouble extends ConstantEntry {
	
	private Byte4 highByte4;
	private Byte4 lowByte4;
	
	public ConstantDouble(byte[] bytes, int offset) {
		super(bytes, offset);
	}
	
	public int parse() {
		offset = tag.parse();
		highByte4 = new Byte4(bytes, offset);
		offset = highByte4.parse();
		lowByte4 = new Byte4(bytes, offset);
		offset = lowByte4.parse();
		return offset;
	}

	public double getDouble() {
		return Double.longBitsToDouble(Byter.toSigned(highByte4.getByte3(),
				highByte4.getByte2(), highByte4.getByte1(), highByte4.getByte0(),
				lowByte4.getByte3(), lowByte4.getByte2(), lowByte4.getByte1(), lowByte4.getByte0()));
	}

	@Override
	public String toString() {
		return "ConstantDouble [getDouble()=" + getDouble() + ", getTag()=" + getTag() + "]";
	}
}

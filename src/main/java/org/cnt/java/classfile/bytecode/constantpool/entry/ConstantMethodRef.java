package org.cnt.java.classfile.bytecode.constantpool.entry;

import org.cnt.java.classfile.bytecode.constantpool.Index;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class ConstantMethodRef extends ConstantEntry {

	private Index classIndex;
	private Index nameAndTypeIndex;
	
	public ConstantMethodRef(byte[] bytes, int offset) {
		super(bytes, offset);
	}
	
	public int parse() {
		offset = tag.parse();
		classIndex = new Index(bytes, offset);
		offset = classIndex.parse();
		nameAndTypeIndex = new Index(bytes, offset);
		offset = nameAndTypeIndex.parse();
		return offset;
	}
	
	public int getClassIndex() {
		return classIndex.getIndex();
	}
	
	public int getNameAndTypeIndex() {
		return nameAndTypeIndex.getIndex();
	}

	@Override
	public String toString() {
		return "ConstantMethodRef [getClassIndex()=" + getClassIndex() + ", getNameAndTypeIndex()="
				+ getNameAndTypeIndex() + ", getTag()=" + getTag() + "]";
	}
}

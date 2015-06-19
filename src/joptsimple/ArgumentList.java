package joptsimple;

class ArgumentList {
	private final String[] arguments;

	private int currentIndex;

	ArgumentList(String... arguments) {
		this.arguments = (arguments.clone());
	}

	boolean hasMore() {
		return this.currentIndex < this.arguments.length;
	}

	String next() {
		return this.arguments[(this.currentIndex++)];
	}

	String peek() {
		return this.arguments[this.currentIndex];
	}

	void treatNextAsLongOption() {
		if ('-' != this.arguments[this.currentIndex].charAt(0)) {
			this.arguments[this.currentIndex] = ("--" + this.arguments[this.currentIndex]);
		}
	}
}

/*
 * Location: M:\AFolderOfMinecraft\Minecraft.jar!\joptsimple\ArgumentList.class
 * Java compiler version: 5 (49.0) JD-Core Version: 0.7.1
 */
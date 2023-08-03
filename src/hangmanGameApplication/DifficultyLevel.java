package hangmanGameApplication;

public enum DifficultyLevel {
	EASY("easy"), MEDIUM("medium"), HARD("hard");

	String difficultyLevel;

	DifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	String getDifficultyLevel() {
		return difficultyLevel;
	}
}

class Main {
	public static void main(String[] args) {
		DatabaseConnection db = new DatabaseConnection();
		InmateGeneratorController inmateGeneratorController = new InmateGeneratorController(db);

		inmateGeneratorController.addInmate("2", "Emily", "Kostic");
		db.close();
	}
}
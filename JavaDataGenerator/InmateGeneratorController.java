
public class InmateGeneratorController {
	private DatabaseConnection db;
	private HousingUnitManager housingUnitManager;
	private InmateCreator inmateCreator;

	InmateGeneratorController(DatabaseConnection db) {
		this.db = db;
		this.housingUnitManager = new HousingUnitManager(db);
		this.inmateCreator = new InmateCreator(db);
	}

	public void addInmate(String docNumber, String firstName, String lastName) {
		String sql = "INSERT INTO Inmate (DOCNumber, FirstName, LastName) VALUES (?, ?, ?)";
		db.insertIntoSQL(sql, docNumber, firstName, lastName);
	}
}

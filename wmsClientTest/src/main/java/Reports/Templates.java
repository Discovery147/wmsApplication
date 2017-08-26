package Reports;

enum Templates {
    Products, Area, Countries, Zones, Positions, Workers;

    Templates() {
    }

    public Templates getProducts() {
        return Templates.Products;
    }

    public Templates getArea() {
        return Templates.Area;
    }

    public Templates getCountries() {
        return Templates.Countries;
    }

    public Templates getZones() {
        return Templates.Zones;
    }

    public Templates getPositions() {
        return Templates.Positions;
    }

    public Templates getWorkers() {
        return Templates.Workers;
    }

    public Templates getIndentity(int i) {
        switch (i) {
            case (0):
                return getProducts();
            case (1):
                return getArea();
            case (2):
                return getCountries();
            case (3):
                return getZones();
            case (4):
                return getPositions();
            case (5):
                return getWorkers();
            default:
                return null;
        }
    }
}

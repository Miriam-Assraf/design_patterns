package Model;

public interface ShipMovetable   {
	public Containerr getContainerByCoords(int xx , int yy );
	public Containerr removeContainer() ;
	public void addContainers(Containerr container);
}

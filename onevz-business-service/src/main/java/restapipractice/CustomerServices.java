package restapipractice;


public interface CustomerServices {

    @DVS(serviceName = ServiceName.SERVICE_A, validateWarning = false)
    public void updateClass();
}

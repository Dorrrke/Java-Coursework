package org.example.kursweb.dao;

public class ConstDao {
    public static final String OWNER_TABLE = "owners";
    public static final String OWNER_ID = "id";
    public static final String OWNER_NAME = "name";
    public static final String OWNER_COMPANY = "company_name";

    public static final String WORKER_TABLE = "workers";
    public static final String WORKER_ID = "id";
    public static final String WORKER_NAME = "name";
    public static final String WORKER_OWNER_ID = "employer_id";

    public static final String ORDER_TABLE = "orders";
    public static final String ORDER_ID = "id";
    public static final String ORDER_NAME = "name";
    public static final String ORDER_DESCRIPTION = "description";
    public static final String ORDER_PRICE = "price";
    public static final String ORDER_WORKER_ID = "worker_id";
}

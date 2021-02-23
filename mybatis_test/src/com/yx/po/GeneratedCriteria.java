package com.yx.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/**
 * 
 * 
 * @author licheng
 * 
 * @date 2021-02-08
 */
class GeneratedCriteria {
    protected List<Criterion> criteria;

    protected GeneratedCriteria() {
        super();
        criteria = new ArrayList<Criterion>();
    }

    public boolean isValid() {
        return criteria.size() > 0;
    }

    public List<Criterion> getAllCriteria() {
        return criteria;
    }

    public List<Criterion> getCriteria() {
        return criteria;
    }

    protected void addCriterion(String condition) {
        if (condition == null) {
            throw new RuntimeException("Value for condition cannot be null");
        }
        criteria.add(new Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
    	Criterion criterion = null;
        if (value == null) {
            throw new RuntimeException("Value for " + property + " cannot be null");
        } else if (value instanceof List<?>) {
        	if (((List<?>) value).size() == 0) {
        		throw new RuntimeException("Value list for " + property + " cannot be empty");
        	} else if ("Date".equals(((List<?>) value).get(0).getClass().getSimpleName())) {
        		@SuppressWarnings("unchecked")
				List<Date> lds = (List<Date>) value;
        		List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
                Iterator<Date> iter = lds.iterator();
                while (iter.hasNext()) {
                    dateList.add(new java.sql.Date(iter.next().getTime()));
                }
                criterion = new Criterion(condition, dateList);
        	} else {
        		criterion = new Criterion(condition, value);
        	}
        } else if ("Date".equals(value.getClass().getSimpleName())) {
        	Date jdbcdate = (Date) value;
        	criterion = new Criterion(condition, new java.sql.Date(jdbcdate.getTime())); 
        } else {
        	criterion = new Criterion(condition, value);
        }
        criteria.add(criterion);
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
    	Criterion criterion = null;
        if (value1 == null || value2 == null) {
            throw new RuntimeException("Between values for " + property + " cannot be null");
        } else if ("Date".equals(value1.getClass().getSimpleName()) && "Date".equals(value2.getClass().getSimpleName())) {
        	Date jdbcdate1 = (Date) value1;
        	Date jdbcdate2 = (Date) value2;
        	criterion = new Criterion(condition, new java.sql.Date(jdbcdate1.getTime()), new java.sql.Date(jdbcdate2.getTime())); 
        } else {
        	criterion = new Criterion(condition, value1, value2);
        }
        criteria.add(criterion);
    }

    protected void addCriterionForJDBCDate(String condition, Date value, String property) {
        if (value == null) {
            throw new RuntimeException("Value for " + property + " cannot be null");
        }
        addCriterion(condition, new java.sql.Date(value.getTime()), property);
    }

    protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
        if (values == null || values.size() == 0) {
            throw new RuntimeException("Value list for " + property + " cannot be null or empty");
        }
        List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
        Iterator<Date> iter = values.iterator();
        while (iter.hasNext()) {
            dateList.add(new java.sql.Date(iter.next().getTime()));
        }
        addCriterion(condition, dateList, property);
    }

    protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
        if (value1 == null || value2 == null) {
            throw new RuntimeException("Between values for " + property + " cannot be null");
        }
        addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
    }

    public void andIsNull(String item) {
        addCriterion(new StringBuffer(item.trim()).append(" is null").toString());
    }

    public void andIsNotNull(String item) {
        addCriterion(new StringBuffer(item.trim()).append(" is not null").toString());
    }

    public void andEqualTo(String item, Object value) {
    	addCriterion(new StringBuffer(item.trim()).append(" =").toString(), value, item);
    }

    public void andNotEqualTo(String item, Object value) {
    	addCriterion(new StringBuffer(item.trim()).append(" <>").toString(), value, item);
    }

    public void andGreaterThan(String item, Object value) {
    	addCriterion(new StringBuffer(item.trim()).append(" >").toString(), value, item);
    }

    public void andGreaterThanOrEqualTo(String item, Object value) {
    	addCriterion(new StringBuffer(item.trim()).append(" >=").toString(), value, item);
    }

    public void andLessThan(String item, Object value) {
    	addCriterion(new StringBuffer(item.trim()).append(" <").toString(), value, item);
    }

    public void andLessThanOrEqualTo(String item, Object value) {
        addCriterion(new StringBuffer(item.trim()).append(" <=").toString(), value, item);
    }

    public void andIn(String item, List<?> values) {
        addCriterion(new StringBuffer(item.trim()).append(" in").toString(), values, item);
    }

    public void andNotIn(String item, List<?> values) {
        addCriterion(new StringBuffer(item.trim()).append(" not in").toString(), values, item);
    }

    public void andBetween(String item, Object value1, Object value2) {
        addCriterion(new StringBuffer(item.trim()).append(" between").toString(), value1, value2, item);
    }

    public void andNotBetween(String item, Object value1, Object value2) {
        addCriterion(new StringBuffer(item.trim()).append(" not between").toString(), value1, value2, item);
    }

    public void andLike(String item, String value) {
        addCriterion(new StringBuffer(item.trim()).append(" like").toString(), value, item);
    }

    public void andNotLike(String item, String value) {
        addCriterion(new StringBuffer(item.trim()).append(" not like").toString(), value, item);
    }
}

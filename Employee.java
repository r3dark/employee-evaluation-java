package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {

	@JsonProperty("name")
	private String name;

	@JsonProperty("current_salary")
	private Integer currentSalary;

	@JsonProperty("rating_in_Q1")
	private Integer ratingQ1;

	@JsonProperty("rating_in_Q2")
	private Integer ratingQ2;

	@JsonProperty("rating_in_Q3")
	private Integer ratingQ3;

	@JsonProperty("rating_in_Q4")
	private Integer ratingQ4;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("average_rating")
	private Double averageRating;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("expected_salary")
	private Double expectedSalary;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("performance_remarks")
	private String performanceType;

	public enum PerformanceType {
//		BEST, AVERAGE, ON_TRACK("ON-TRACK");
		BEST, AVERAGE, ON_TRACK
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCurrentSalary() {
		return currentSalary;
	}

	public void setCurrentSalary(Integer currentSalary) {
		this.currentSalary = currentSalary;
	}

	public Integer getRatingQ1() {
		return ratingQ1;
	}

	public void setRatingQ1(Integer ratingQ1) {
		this.ratingQ1 = ratingQ1;
	}

	public Integer getRatingQ2() {
		return ratingQ2;
	}

	public void setRatingQ2(Integer ratingQ2) {
		this.ratingQ2 = ratingQ2;
	}

	public Integer getRatingQ3() {
		return ratingQ3;
	}

	public void setRatingQ3(Integer ratingQ3) {
		this.ratingQ3 = ratingQ3;
	}

	public Integer getRatingQ4() {
		return ratingQ4;
	}

	public void setRatingQ4(Integer ratingQ4) {
		this.ratingQ4 = ratingQ4;
	}

	public Double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}

	public Double getExpectedSalary() {
		return expectedSalary;
	}

	public void setExpectedSalary(Double expectedSalary) {
		this.expectedSalary = expectedSalary;
	}

	public String getPerformanceType() {
		return performanceType;
	}

	public void setPerformanceType(String performanceType) {
		this.performanceType = performanceType;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"name='" + name + '\'' +
				", currentSalary=" + currentSalary +
				", ratingQ1=" + ratingQ1 +
				", ratingQ2=" + ratingQ2 +
				", ratingQ3=" + ratingQ3 +
				", ratingQ4=" + ratingQ4 +
				", averageRating=" + averageRating +
				", expectedSalary=" + expectedSalary +
				", performanceType=" + performanceType +
				'}';
	}
}

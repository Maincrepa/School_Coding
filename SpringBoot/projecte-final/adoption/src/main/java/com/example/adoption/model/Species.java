package com.example.adoption.model;

// Framework

import jakarta.persistence.*;
// Java


@Entity
@Table(name = "Species")
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Code")
    private Integer id;

    @Column(name = "Type")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "CareTip")
    private String careTip;

    @Column(name = "AverageLifespan")
    private Integer averageLifespan;

    @Column(name = "AverageWeight")
    private java.math.BigDecimal averageWeight;

    @Column(name = "SizeCategory")
    private String sizeCategory;

    @Column(name = "ActivityLevel")
    private String activityLevel;

    @Column(name = "IsHypoallergenic")
    private Boolean isHypoallergenic;

    @Column(name = "IsGoodWithChildren")
    private Boolean isGoodWithChildren;

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getCareTip() { return careTip; }
    public void setCareTip(String careTip) { this.careTip = careTip; }
    
    public Integer getAverageLifespan() { return averageLifespan; }
    public void setAverageLifespan(Integer averageLifespan) { this.averageLifespan = averageLifespan; }
    
    public java.math.BigDecimal getAverageWeight() { return averageWeight; }
    public void setAverageWeight(java.math.BigDecimal averageWeight) { this.averageWeight = averageWeight; }
    
    public String getSizeCategory() { return sizeCategory; }
    public void setSizeCategory(String sizeCategory) { this.sizeCategory = sizeCategory; }
    
    public String getActivityLevel() { return activityLevel; }
    public void setActivityLevel(String activityLevel) { this.activityLevel = activityLevel; }
    
    public Boolean getIsHypoallergenic() { return isHypoallergenic; }
    public void setIsHypoallergenic(Boolean isHypoallergenic) { this.isHypoallergenic = isHypoallergenic; }
    
    public Boolean getIsGoodWithChildren() { return isGoodWithChildren; }
    public void setIsGoodWithChildren(Boolean isGoodWithChildren) { this.isGoodWithChildren = isGoodWithChildren; }
}
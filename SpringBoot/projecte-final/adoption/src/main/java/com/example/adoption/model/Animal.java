package com.example.adoption.model;

// Framework
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

// Java
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Pets")
public class Animal {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Code")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "BirthDate")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;

    @NotNull(message = "Species ID is required")
    @Column(name = "IdSpecie", nullable = false)
    private Integer speciesId;

    @Column(name = "Adoptat")
    private Boolean adopted;

    @Column(name = "DataAdoptat")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate adoptedDate;

    @Column(name = "DataRegistrat", insertable = false, updatable = false)
    private LocalDateTime registeredDate;

    @Column(name = "Weight")
    private BigDecimal weight;

    @Column(name = "Height")
    private BigDecimal height;

    @Column(name = "Breed")
    private String breed;

    @Column(name = "Color")
    private String color;

    @Column(name = "Size")
    private String size;

    @Column(name = "IsNeutered")
    private Boolean isNeutered;

    @Column(name = "IsVaccinated")
    private Boolean isVaccinated;

    @Column(name = "IsMicrochipped")
    private Boolean isMicrochipped;

    @Column(name = "HealthStatus")
    private String healthStatus;

    @Column(name = "Temperament")
    private String temperament;

    @Column(name = "Description")
    private String description;

    @Column(name = "PhotoURL")
    private String photoUrl;

    @Column(name = "AdopterID")
    private Integer adopterId;

    // Setters
    public void setId(Long newId) { id = newId; }
    public void setName(String newName) { name = newName; }
    public void setGender(String newGender) { gender = newGender; }
    public void setBirthDate(LocalDate newBirthDate) { birthDate = newBirthDate; }
    public void setSpeciesId(Integer newSpeciesId) { speciesId = newSpeciesId; }
    public void setAdopted(Boolean newAdopted) { adopted = newAdopted; }
    public void setAdoptedDate(LocalDate newAdoptedDate) { adoptedDate = newAdoptedDate; }
    public void setRegisteredDate(LocalDateTime newRegisteredDate) { registeredDate = newRegisteredDate; }
    public void setWeight(BigDecimal newWeight) { weight = newWeight; }
    public void setHeight(BigDecimal newHeight) { height = newHeight; }
    public void setBreed(String newBreed) { breed = newBreed; }
    public void setColor(String newColor) { color = newColor; }
    public void setSize(String newSize) { size = newSize; }
    public void setIsNeutered(Boolean newIsNeutered) { isNeutered = newIsNeutered; }
    public void setIsVaccinated(Boolean newIsVaccinated) { isVaccinated = newIsVaccinated; }
    public void setIsMicrochipped(Boolean newIsMicrochipped) { isMicrochipped = newIsMicrochipped; }
    public void setHealthStatus(String newHealthStatus) { healthStatus = newHealthStatus; }
    public void setTemperament(String newTemperament) { temperament = newTemperament; }
    public void setDescription(String newDescription) { description = newDescription; }
    public void setPhotoUrl(String newPhotoUrl) { photoUrl = newPhotoUrl; }
    public void setAdopterId(Integer newAdopterId) { adopterId = newAdopterId; }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public LocalDate getBirthDate() { return birthDate; }
    public Integer getSpeciesId() { return speciesId; }
    public Boolean getAdopted() { return adopted; }
    public LocalDate getAdoptedDate() { return adoptedDate; }
    public LocalDateTime getRegisteredDate() { return registeredDate; }
    public BigDecimal getWeight() { return weight; }
    public BigDecimal getHeight() { return height; }
    public String getBreed() { return breed; }
    public String getColor() { return color; }
    public String getSize() { return size; }
    public Boolean getIsNeutered() { return isNeutered; }
    public Boolean getIsVaccinated() { return isVaccinated; }
    public Boolean getIsMicrochipped() { return isMicrochipped; }
    public String getHealthStatus() { return healthStatus; }
    public String getTemperament() { return temperament; }
    public String getDescription() { return description; }
    public String getPhotoUrl() { return photoUrl; }
    public Integer getAdopterId() { return adopterId; }
}
package com.healthcare.HealingXpert.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author KUMAR
 */
@Entity
@Table(name = "doctor_slot")
public class DoctorSlot implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "doctor_details_id", insertable = false, updatable = false)
	@JsonIgnoreProperties("doctorSlots")
	private DoctorDetails doctorDetails;

	@Column(name = "day_week", nullable = false)
	private int dayWeek;

	@Column(name = "slot_date", nullable = false)
	private Date slotDate;

	@Column(name = "day_name", nullable = false, length = 15)
	private String dayName;

	@Column(name = "slot_duration_mnts")
	private int slotDuration;

	@Column(name = "slot_start", nullable = false)
	private Timestamp slotStart;

	@Column(name = "slot_end", nullable = false)
	private Timestamp slotEnd;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_slot_id")
	@JsonIgnoreProperties("doctorSlot")
	private List<Slot> slots;

	@Column(name = "break_start")
	private Timestamp breakStart;

	@Column(name = "break_end")
	private Timestamp breakEnd;

	@Column(name = "status", nullable = false, length = 25)
	private String status;

	@Column(name = "day_week_text", length = 100)
	private String dayWeekText;

	@Column(name = "is_booked", columnDefinition = "default false")
	private boolean isBooked;

	@Column(name = "version", length = 20)
	private String version;

	@Column(name = "ip_address", length = 50)
	private String ipAddress;

	@Column(name = "created_by", length = 100)
	private String createdBy;

	@Column(name = "created_date")
	private Timestamp createdDate;

	public DoctorSlot() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDayWeek() {
		return dayWeek;
	}

	public void setDayWeek(int dayWeek) {
		this.dayWeek = dayWeek;
	}

	public Timestamp getSlotStart() {
		return slotStart;
	}

	public void setSlotStart(Timestamp slotStart) {
		this.slotStart = slotStart;
	}

	public Timestamp getSlotEnd() {
		return slotEnd;
	}

	public void setSlotEnd(Timestamp slotEnd) {
		this.slotEnd = slotEnd;
	}

	public Date getSlotDate() {
		return slotDate;
	}

	public void setSlotDate(Date slotDate) {
		this.slotDate = slotDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDayWeekText() {
		return dayWeekText;
	}

	public void setDayWeekText(String dayWeekText) {
		this.dayWeekText = dayWeekText;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getBreakStart() {
		return breakStart;
	}

	public void setBreakStart(Timestamp breakStart) {
		this.breakStart = breakStart;
	}

	public Timestamp getBreakEnd() {
		return breakEnd;
	}

	public void setBreakEnd(Timestamp breakEnd) {
		this.breakEnd = breakEnd;
	}

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

	public DoctorDetails getDoctorDetails() {
		return doctorDetails;
	}

	public void setDoctorDetails(DoctorDetails doctorDetails) {
		this.doctorDetails = doctorDetails;
	}

	public List<Slot> getSlots() {
		return slots;
	}

	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}

	public String getDayName() {
		return dayName;
	}

	public void setDayName(String dayName) {
		this.dayName = dayName;
	}

	public int getSlotDuration() {
		return slotDuration;
	}

	public void setSlotDuration(int slotDuration) {
		this.slotDuration = slotDuration;
	}

}
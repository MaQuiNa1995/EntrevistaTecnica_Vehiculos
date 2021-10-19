package com.ing.interview.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Getter
@Setter
public class Car {

	@Column(name = "ID",
	        nullable = false)
	@GeneratedValue(generator = "Sequence",
	        strategy = SEQUENCE)
	@SequenceGenerator(name = "Sequence",
	        sequenceName = "SEQUENCE_CAR",
	        allocationSize = 1)
	@Id
	@EqualsAndHashCode.Exclude
	private Long id;
	private String color;
	private String model;
	@CreationTimestamp
	private LocalDate orderDate;

}

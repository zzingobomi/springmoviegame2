package org.zzingobomi.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "tbl_movieflowinfos")
@EqualsAndHashCode(of = "mfno")
@ToString(exclude = "nextfilefnos")
public class MovieFlowInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mfno;
	private String filename;	
	
	
	@ElementCollection(fetch=FetchType.EAGER)		// 이게 맞는걸까...
	List<Long> nextfilefnos;
}

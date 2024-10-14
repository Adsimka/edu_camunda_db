package com.worker.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "access_request")
public class AccessRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "entity_id", nullable = false)
    private Long entityId;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "comment")
    private String comment;

    @Column(name = "approver")
    private String approver;

    @Column(name = "is_approved")
    private Boolean isApproved;
}

package com.inducingemotion.InducingEmotion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "videos")
@Data
public class Video {
    private long id;

}

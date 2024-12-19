package com.udea.siiuseguimproyectosback.domain.dto.announcement;

import lombok.Data;

/**
 * Data Transfer Object (DTO) for an Announcement(CONVOCATORIA) entity.
 * <p>
 * This class is used to transfer announcement data between different layers of the application. It represents
 * an announcement with essential attributes like its ID and name.
 * </p>
 *
 * <p>
 * The {@link AnnouncementDTO} class is annotated with {@link lombok.Data} to automatically generate boilerplate
 * code such as getters, setters, {@link Object#toString()}, {@link Object#equals(Object)}, and {@link Object#hashCode()}
 * methods, which makes it convenient for use as a data transfer object.
 * </p>
 *
 * @see lombok.Data
 */
@Data
public class AnnouncementDTO {

    /**
     * The unique identifier for the announcement.
     * <p>
     * This ID is typically used to identify the announcement in the database or other systems.
     * </p>
     */
    private Long id;

    /**
     * The name of the announcement.
     * <p>
     * This field stores the name or title of the announcement, which could represent an event, news, or other types of announcements.
     * </p>
     */
    private String name;
}

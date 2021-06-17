package com.datasirpi.contacts.data.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author sabique
 */
@Getter
@Setter
@NoArgsConstructor
public class ContactResponse {
    private String id;
    private String name;
    private String mobile;
    private String email;
}

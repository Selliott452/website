package com.elliott.website.views.components

import com.vaadin.flow.component.Component
import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.html.H3
import com.vaadin.flow.component.html.Image
import com.vaadin.flow.component.html.Paragraph
import com.vaadin.flow.component.icon.Icon
import com.vaadin.flow.component.icon.VaadinIcon
import com.vaadin.flow.router.RouterLink

class NavCard(
    title: String,
    description: String,
    navigationTarget: Class<out Component>,
    imageUrl: String? = null
) : RouterLink() {

    init {
        addClassName("nav-card-link")
        setRoute(navigationTarget)

        add(Div().apply {
            addClassName("nav-card")

            if (imageUrl != null) {
                add(Image(imageUrl, title).apply { addClassName("nav-card-image") })
            }

            add(Div().apply {
                addClassName("nav-card-content")
                add(
                    Div().apply {
                        addClassName("nav-card-header")
                        add(H3(title).apply { addClassName("nav-card-title") })
                        add(Icon(VaadinIcon.CHEVRON_RIGHT_SMALL).apply { addClassName("nav-card-icon") })
                    },
                    Paragraph(description).apply { addClassName("nav-card-description") }
                )
            })
        })
    }
}

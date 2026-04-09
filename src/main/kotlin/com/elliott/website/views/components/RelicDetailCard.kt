package com.elliott.website.views.components

import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.html.Image
import com.vaadin.flow.component.html.UnorderedList

class RelicDetailCard(
    title: String,
    imageUrl: String,
    details: UnorderedList
) : Div() {

    init {
        addClassName("relic-detail-card")

        add(Image(imageUrl, title).apply { addClassName("relic-detail-image") })
        add(Div().apply {
            addClassName("relic-detail-content")
            add(details)
        })
    }
}

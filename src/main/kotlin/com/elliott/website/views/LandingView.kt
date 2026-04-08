package com.elliott.website.views

import com.vaadin.flow.component.html.H2
import com.vaadin.flow.component.html.Paragraph
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route

@Route(value = "", layout = MainLayout::class)
@PageTitle("Home")
class LandingView : VerticalLayout() {

    init {
        defaultHorizontalComponentAlignment = Alignment.CENTER
        addClassName("landing-view")
        add(
            H2("Welcome"),
            Paragraph("Sam Elliott's personal website. More content coming soon.")
        )
    }
}

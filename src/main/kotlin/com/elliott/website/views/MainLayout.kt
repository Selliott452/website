package com.elliott.website.views

import com.vaadin.flow.component.applayout.AppLayout
import com.vaadin.flow.component.applayout.DrawerToggle
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.button.ButtonVariant
import com.vaadin.flow.component.html.H2
import com.vaadin.flow.component.icon.Icon
import com.vaadin.flow.component.icon.VaadinIcon
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.tabs.Tab
import com.vaadin.flow.component.tabs.Tabs
import com.vaadin.flow.router.AfterNavigationEvent
import com.vaadin.flow.router.AfterNavigationObserver
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.RouterLink

class MainLayout : AppLayout(), AfterNavigationObserver {

    private val pageTitle = H2("")

    init {
        createHeader()
        createDrawer()
    }

    private fun createHeader() {
        pageTitle.addClassName("page-title")

        val titleSection = HorizontalLayout(pageTitle).apply {
            defaultVerticalComponentAlignment = Alignment.CENTER
            addClassName("title-section")
        }

        val homeButton = Button(Icon(VaadinIcon.HOME)) {
            ui.ifPresent { it.navigate("") }
        }.apply {
            addThemeVariants(ButtonVariant.LUMO_TERTIARY)
            setAriaLabel("Home")
        }

        val darkModeToggle = Button(Icon(VaadinIcon.MOON)).apply {
            addThemeVariants(ButtonVariant.LUMO_TERTIARY)
            setAriaLabel("Toggle dark mode")
        }
        darkModeToggle.addClickListener {
            val isDark = !darkModeToggle.ui.get().element.themeList.contains("dark")
            darkModeToggle.ui.get().element.themeList.set("dark", isDark)
            darkModeToggle.icon = Icon(if (isDark) VaadinIcon.SUN_O else VaadinIcon.MOON)
        }

        val rightSection = HorizontalLayout(homeButton, darkModeToggle).apply {
            defaultVerticalComponentAlignment = Alignment.CENTER
        }

        HorizontalLayout(DrawerToggle(), titleSection, rightSection).apply {
            defaultVerticalComponentAlignment = Alignment.CENTER
            setWidthFull()
            addClassName("main-header")
            addToNavbar(this)
        }
    }

    private fun createDrawer() {
        val tabs = Tabs(Tab(RouterLink("Home", LandingView::class.java))).apply {
            orientation = Tabs.Orientation.VERTICAL
            setWidthFull()
        }

        addToDrawer(VerticalLayout(tabs).apply {
            setSizeFull()
            isPadding = false
            isSpacing = false
        })
    }

    override fun afterNavigation(event: AfterNavigationEvent) {
        pageTitle.text = content?.javaClass?.getAnnotation(PageTitle::class.java)?.value ?: ""
    }
}

<div class="page-sidebar-wrapper">
	<div class="page-sidebar navbar-collapse collapse">
		 <!-- BEGIN SIDEBAR MENU -->
		 <ul class="page-sidebar-menu  page-header-fixed " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200" style="padding-top: 20px">
		 	<template v-for="(menu, i) in menu_list">
				<li class="nav-item menu-li" :class="{start: i == 1, open: menu.state.opened, active: menu.state.selected}" :data-id="menu.id">
					<a :href="menu.href" class="nav-link nav-toggle">
						<i :class="menu.span_icon"></i>
						<span class="title" v-text="menu.text"></span>
						<span class="selected"></span>
						<span class="arrow"></span>
					</a>
					<ul v-if="menu.children" class="sub-menu">
						<li v-for="child in menu.children">
							<a :href="child.href">
								<i :class="child.span_icon" ></i>((child.text))
							</a>
						</li>
					</ul>
				</li>
			</template>
		</ul>
		<!-- END SIDEBAR MENU -->
	</div>
</div>
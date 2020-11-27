FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
file://lvds15/pointercal \
file://lvds10/pointercal \
"

do_install_append_rescue () {
	for disp in ${DISPLAY_INFO}; do
		if [ "$disp" = "lvds15" ]; then
			install -m 0644 ${WORKDIR}/lvds15/pointercal ${D}${sysconfdir}/pointercal
		elif [ "$disp" = "lvds10" ]; then
			install -m 0644 ${WORKDIR}/lvds10/pointercal ${D}${sysconfdir}/pointercal
		fi
	done
}

FILES_tslib-conf_append = " ${sysconfdir}/pointercal"
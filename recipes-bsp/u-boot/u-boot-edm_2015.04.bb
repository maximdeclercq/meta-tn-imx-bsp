require recipes-bsp/u-boot/u-boot.inc

DESCRIPTION = "u-boot Technexion boards."
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=c7383a594871c03da76b3707929d2919"

PROVIDES += "u-boot"

SRCBRANCH = "tn-imx_v2015.04_4.1.15_1.0.0_ga"
SRCREV = "d7ebd0b55429faef8c3e0dbf7189ea11707ec25d"
SRC_URI = "git://github.com/TechNexion/u-boot-edm.git;branch=${SRCBRANCH} \
           file://uEnv.txt \
           "

deploy_uenv () {
	install ${WORKDIR}/uEnv.txt ${DEPLOYDIR}/uEnv.txt
}

do_deploy[postfuncs] += "deploy_uenv"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(edm1-cf-imx6)"
require recipes-bsp/u-boot/u-boot-common.inc
require recipes-bsp/u-boot/u-boot.inc

PROVIDES += "u-boot"

DEPENDS += "bc-native dtc-native"

SRCREV = "47cc6eedb7df5cd88477836250548560e8bf043f"
PATCHTOOL = "git"

SRC_URI = "git://github.com/eswincomputing/u-boot.git;protocol=https;branch=u-boot-2024.01-EIC7X \
           file://0001-riscv-hifive_premier_p550-defined-boot-media-sequenc.patch \
           file://0001-hifive-premier-p550-drivers-video-update-logo.patch \
           file://Add-video-damage-tracking.patch \
           file://disable-VBE-by-default.patch \
           file://enable-bootmenu-by-default.patch \
           file://uefi-Add-all-options-for-EFI-System-Partitions.patch \
           file://uefi-distro-load-FDT-from-any-partition-on-boot-device.patch \
           file://uefi-initial-find_fdt_location-for-finding-the-DT-on-disk.patch"

do_deploy:append () {
	install -m 755 ${B}/u-boot.dtb ${DEPLOYDIR}
}

COMPATIBLE_MACHINE = "hifive-premier-p550"

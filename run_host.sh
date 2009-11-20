#!/bin/sh

cd SunSpotHostApplication
ant host-run -Dbasestation.shared=true -Dbasestation.not.required=true

/*
 * Jitsi, the OpenSource Java VoIP and Instant Messaging client.
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 */
package org.jitsi.impl.neomedia.device;

import java.util.*;

/**
 * Manages the list of active (currently plugged-in) playback devices and
 * manages user preferences between all known devices (previously and actually
 * plugged-in).
 *
 * @author Vincent Lucas
 */
public class PlaybackDevices
    extends Devices
{
    /**
     * The property of the playback devices.
     */
    public static final String PROP_DEVICE = "playbackDevice";

    /**
     * The list of active (actually plugged-in) playback devices.
     */
    private List<ExtendedCaptureDeviceInfo> activePlaybackDevices;

    /**
     * Initializes the playback device list management.
     *
     * @param audioSystem The audio system managing this playback device list.
     */
    public PlaybackDevices(AudioSystem audioSystem)
    {
        super(audioSystem);
    }

    /**
     * Returns the list of the active devices.
     *
     * @return The list of the active devices.
     */
    public List<ExtendedCaptureDeviceInfo> getDevices()
    {
        List<ExtendedCaptureDeviceInfo> devices;

        if (activePlaybackDevices == null)
            devices = Collections.emptyList();
        else
        {
            devices
                = new ArrayList<ExtendedCaptureDeviceInfo>(
                        activePlaybackDevices);
        }

        return devices;
    }

    /**
     * Returns the property of the capture devices.
     *
     * @return The property of the capture devices.
     */
    protected String getPropDevice()
    {
        return PROP_DEVICE;
    }

    /**
     * Sets the list of the active devices.
     *
     * @param activeDevices The list of the active devices.
     */
    public void setActiveDevices(List<ExtendedCaptureDeviceInfo> activeDevices)
    {
        activePlaybackDevices
            = (activeDevices == null)
                ? null
                : new ArrayList<ExtendedCaptureDeviceInfo>(activeDevices);
    }
}
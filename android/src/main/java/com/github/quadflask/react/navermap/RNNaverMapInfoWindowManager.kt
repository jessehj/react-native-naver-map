package com.github.quadflask.react.navermap

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import com.naver.maps.map.overlay.Align
import com.naver.maps.map.overlay.InfoWindow

open class RNNaverMapInfoWindowManager(reactContext: ReactApplicationContext) : EventEmittableViewGroupManager<RNNaverMapInfoWindow?>(reactContext) {
  override fun getName(): String = "RNNaverMapInfoWindow"

  override fun createViewInstance(reactContext: ThemedReactContext): RNNaverMapInfoWindow {
    return RNNaverMapInfoWindow(this, reactContext)
  }

  @ReactProp(name = "coordinate")
  fun setCoordinate(view: RNNaverMapMarker, map: ReadableMap?) {
    view.setCoordinate(ReactUtil.toNaverLatLng(map))
  }

  @ReactProp(name = "text")
  fun setText(view: RNNaverMapInfoWindow, text: String?) {
    view.setText(text)
  }

  @ReactProp(name = "open", defaultBoolean = false)
  fun setOpen(view: RNNaverMapInfoWindow, open: Boolean) {
    view.setOpen(open)
  }

  @ReactProp(name = "align", defaultInt = -1)
  fun setAlign(view: RNNaverMapInfoWindow, align: Int) {
    view.setAlign(ReactUtil.parseAlign(align, Align.Top))
  }

  @ReactProp(name = "anchor")
  fun setAnchor(view: RNNaverMapInfoWindow, map: ReadableMap?) {
    view.setAnchor(ReactUtil.toPointF(map, InfoWindow.DEFAULT_ANCHOR))
  }

  @ReactProp(name = "offsetX", defaultInt = 0)
  fun setOffsetX(view: RNNaverMapInfoWindow, offset: Int) {
    view.setOffsetX(offset)
  }

  @ReactProp(name = "offsetY", defaultInt = 0)
  fun setOffsetY(view: RNNaverMapInfoWindow, offset: Int) {
    view.setOffsetY(offset)
  }

  @ReactProp(name = "alpha", defaultFloat = 1f)
  fun setAlpha(view: RNNaverMapInfoWindow, alpha: Float) {
    view.alpha = alpha
  }
}

// Autogenerated from Pigeon (v22.7.0), do not edit directly.
// See also: https://pub.dev/packages/pigeon
@file:Suppress("UNCHECKED_CAST", "ArrayInDataClass")

package com.rohit.ble_peripheral

import android.util.Log
import io.flutter.plugin.common.BasicMessageChannel
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.EventChannel
import io.flutter.plugin.common.MessageCodec
import io.flutter.plugin.common.StandardMethodCodec
import io.flutter.plugin.common.StandardMessageCodec
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer

private fun wrapResult(result: Any?): List<Any?> {
  return listOf(result)
}

private fun wrapError(exception: Throwable): List<Any?> {
  return if (exception is FlutterError) {
    listOf(
      exception.code,
      exception.message,
      exception.details
    )
  } else {
    listOf(
      exception.javaClass.simpleName,
      exception.toString(),
      "Cause: " + exception.cause + ", Stacktrace: " + Log.getStackTraceString(exception)
    )
  }
}

private fun createConnectionError(channelName: String): FlutterError {
  return FlutterError("channel-error",  "Unable to establish connection on channel: '$channelName'.", "")}

/**
 * Error class for passing custom error details to Flutter via a thrown PlatformException.
 * @property code The error code.
 * @property message The error message.
 * @property details The error details. Must be a datatype supported by the api codec.
 */
class FlutterError (
  val code: String,
  override val message: String? = null,
  val details: Any? = null
) : Throwable()

/** Enums */
enum class BondState(val raw: Int) {
  BONDING(0),
  BONDED(1),
  NONE(2);

  companion object {
    fun ofRaw(raw: Int): BondState? {
      return values().firstOrNull { it.raw == raw }
    }
  }
}

/**
 * Models
 *
 * Generated class from Pigeon that represents data sent in messages.
 */
data class BleService (
  val uuid: String,
  val primary: Boolean,
  val characteristics: List<BleCharacteristic>
)
 {
  companion object {
    fun fromList(pigeonVar_list: List<Any?>): BleService {
      val uuid = pigeonVar_list[0] as String
      val primary = pigeonVar_list[1] as Boolean
      val characteristics = pigeonVar_list[2] as List<BleCharacteristic>
      return BleService(uuid, primary, characteristics)
    }
  }
  fun toList(): List<Any?> {
    return listOf(
      uuid,
      primary,
      characteristics,
    )
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class BleCharacteristic (
  val uuid: String,
  val properties: List<Long>,
  val permissions: List<Long>,
  val descriptors: List<BleDescriptor>? = null,
  val value: ByteArray? = null
)
 {
  companion object {
    fun fromList(pigeonVar_list: List<Any?>): BleCharacteristic {
      val uuid = pigeonVar_list[0] as String
      val properties = pigeonVar_list[1] as List<Long>
      val permissions = pigeonVar_list[2] as List<Long>
      val descriptors = pigeonVar_list[3] as List<BleDescriptor>?
      val value = pigeonVar_list[4] as ByteArray?
      return BleCharacteristic(uuid, properties, permissions, descriptors, value)
    }
  }
  fun toList(): List<Any?> {
    return listOf(
      uuid,
      properties,
      permissions,
      descriptors,
      value,
    )
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class BleDescriptor (
  val uuid: String,
  val value: ByteArray? = null,
  val permissions: List<Long>? = null
)
 {
  companion object {
    fun fromList(pigeonVar_list: List<Any?>): BleDescriptor {
      val uuid = pigeonVar_list[0] as String
      val value = pigeonVar_list[1] as ByteArray?
      val permissions = pigeonVar_list[2] as List<Long>?
      return BleDescriptor(uuid, value, permissions)
    }
  }
  fun toList(): List<Any?> {
    return listOf(
      uuid,
      value,
      permissions,
    )
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class ReadRequestResult (
  val value: ByteArray,
  val offset: Long? = null,
  val status: Long? = null
)
 {
  companion object {
    fun fromList(pigeonVar_list: List<Any?>): ReadRequestResult {
      val value = pigeonVar_list[0] as ByteArray
      val offset = pigeonVar_list[1] as Long?
      val status = pigeonVar_list[2] as Long?
      return ReadRequestResult(value, offset, status)
    }
  }
  fun toList(): List<Any?> {
    return listOf(
      value,
      offset,
      status,
    )
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class WriteRequestResult (
  val value: ByteArray? = null,
  val offset: Long? = null,
  val status: Long? = null
)
 {
  companion object {
    fun fromList(pigeonVar_list: List<Any?>): WriteRequestResult {
      val value = pigeonVar_list[0] as ByteArray?
      val offset = pigeonVar_list[1] as Long?
      val status = pigeonVar_list[2] as Long?
      return WriteRequestResult(value, offset, status)
    }
  }
  fun toList(): List<Any?> {
    return listOf(
      value,
      offset,
      status,
    )
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class ManufacturerData (
  val manufacturerId: Long,
  val data: ByteArray
)
 {
  companion object {
    fun fromList(pigeonVar_list: List<Any?>): ManufacturerData {
      val manufacturerId = pigeonVar_list[0] as Long
      val data = pigeonVar_list[1] as ByteArray
      return ManufacturerData(manufacturerId, data)
    }
  }
  fun toList(): List<Any?> {
    return listOf(
      manufacturerId,
      data,
    )
  }
}
private open class BlePeripheralPigeonCodec : StandardMessageCodec() {
  override fun readValueOfType(type: Byte, buffer: ByteBuffer): Any? {
    return when (type) {
      129.toByte() -> {
        return (readValue(buffer) as Long?)?.let {
          BondState.ofRaw(it.toInt())
        }
      }
      130.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          BleService.fromList(it)
        }
      }
      131.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          BleCharacteristic.fromList(it)
        }
      }
      132.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          BleDescriptor.fromList(it)
        }
      }
      133.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          ReadRequestResult.fromList(it)
        }
      }
      134.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          WriteRequestResult.fromList(it)
        }
      }
      135.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          ManufacturerData.fromList(it)
        }
      }
      else -> super.readValueOfType(type, buffer)
    }
  }
  override fun writeValue(stream: ByteArrayOutputStream, value: Any?)   {
    when (value) {
      is BondState -> {
        stream.write(129)
        writeValue(stream, value.raw)
      }
      is BleService -> {
        stream.write(130)
        writeValue(stream, value.toList())
      }
      is BleCharacteristic -> {
        stream.write(131)
        writeValue(stream, value.toList())
      }
      is BleDescriptor -> {
        stream.write(132)
        writeValue(stream, value.toList())
      }
      is ReadRequestResult -> {
        stream.write(133)
        writeValue(stream, value.toList())
      }
      is WriteRequestResult -> {
        stream.write(134)
        writeValue(stream, value.toList())
      }
      is ManufacturerData -> {
        stream.write(135)
        writeValue(stream, value.toList())
      }
      else -> super.writeValue(stream, value)
    }
  }
}

/**
 * Flutter -> Native
 *
 * Generated interface from Pigeon that represents a handler of messages from Flutter.
 */
interface BlePeripheralChannel {
  fun initialize()
  fun isAdvertising(): Boolean?
  fun isSupported(): Boolean
  fun stopAdvertising()
  fun askBlePermission(): Boolean
  fun addService(service: BleService)
  fun removeService(serviceId: String)
  fun clearServices()
  fun getServices(): List<String>
  fun startAdvertising(services: List<String>, localName: String?, timeout: Long?, manufacturerData: ManufacturerData?, addManufacturerDataInScanResponse: Boolean)
  fun updateCharacteristic(characteristicId: String, value: ByteArray, deviceId: String?)

  companion object {
    /** The codec used by BlePeripheralChannel. */
    val codec: MessageCodec<Any?> by lazy {
      BlePeripheralPigeonCodec()
    }
    /** Sets up an instance of `BlePeripheralChannel` to handle messages through the `binaryMessenger`. */
    @JvmOverloads
    fun setUp(binaryMessenger: BinaryMessenger, api: BlePeripheralChannel?, messageChannelSuffix: String = "") {
      val separatedMessageChannelSuffix = if (messageChannelSuffix.isNotEmpty()) ".$messageChannelSuffix" else ""
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.ble_peripheral.BlePeripheralChannel.initialize$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped: List<Any?> = try {
              api.initialize()
              listOf(null)
            } catch (exception: Throwable) {
              wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.ble_peripheral.BlePeripheralChannel.isAdvertising$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped: List<Any?> = try {
              listOf(api.isAdvertising())
            } catch (exception: Throwable) {
              wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.ble_peripheral.BlePeripheralChannel.isSupported$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped: List<Any?> = try {
              listOf(api.isSupported())
            } catch (exception: Throwable) {
              wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.ble_peripheral.BlePeripheralChannel.stopAdvertising$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped: List<Any?> = try {
              api.stopAdvertising()
              listOf(null)
            } catch (exception: Throwable) {
              wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.ble_peripheral.BlePeripheralChannel.askBlePermission$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped: List<Any?> = try {
              listOf(api.askBlePermission())
            } catch (exception: Throwable) {
              wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.ble_peripheral.BlePeripheralChannel.addService$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val serviceArg = args[0] as BleService
            val wrapped: List<Any?> = try {
              api.addService(serviceArg)
              listOf(null)
            } catch (exception: Throwable) {
              wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.ble_peripheral.BlePeripheralChannel.removeService$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val serviceIdArg = args[0] as String
            val wrapped: List<Any?> = try {
              api.removeService(serviceIdArg)
              listOf(null)
            } catch (exception: Throwable) {
              wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.ble_peripheral.BlePeripheralChannel.clearServices$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped: List<Any?> = try {
              api.clearServices()
              listOf(null)
            } catch (exception: Throwable) {
              wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.ble_peripheral.BlePeripheralChannel.getServices$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped: List<Any?> = try {
              listOf(api.getServices())
            } catch (exception: Throwable) {
              wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.ble_peripheral.BlePeripheralChannel.startAdvertising$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val servicesArg = args[0] as List<String>
            val localNameArg = args[1] as String?
            val timeoutArg = args[2] as Long?
            val manufacturerDataArg = args[3] as ManufacturerData?
            val addManufacturerDataInScanResponseArg = args[4] as Boolean
            val wrapped: List<Any?> = try {
              api.startAdvertising(servicesArg, localNameArg, timeoutArg, manufacturerDataArg, addManufacturerDataInScanResponseArg)
              listOf(null)
            } catch (exception: Throwable) {
              wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.ble_peripheral.BlePeripheralChannel.updateCharacteristic$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val characteristicIdArg = args[0] as String
            val valueArg = args[1] as ByteArray
            val deviceIdArg = args[2] as String?
            val wrapped: List<Any?> = try {
              api.updateCharacteristic(characteristicIdArg, valueArg, deviceIdArg)
              listOf(null)
            } catch (exception: Throwable) {
              wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
    }
  }
}
/**
 * Native -> Flutter
 *
 * Generated class from Pigeon that represents Flutter messages that can be called from Kotlin.
 */
class BleCallback(private val binaryMessenger: BinaryMessenger, private val messageChannelSuffix: String = "") {
  companion object {
    /** The codec used by BleCallback. */
    val codec: MessageCodec<Any?> by lazy {
      BlePeripheralPigeonCodec()
    }
  }
  fun onReadRequest(deviceIdArg: String, characteristicIdArg: String, offsetArg: Long, valueArg: ByteArray?, callback: (Result<ReadRequestResult?>) -> Unit)
{
    val separatedMessageChannelSuffix = if (messageChannelSuffix.isNotEmpty()) ".$messageChannelSuffix" else ""
    val channelName = "dev.flutter.pigeon.ble_peripheral.BleCallback.onReadRequest$separatedMessageChannelSuffix"
    val channel = BasicMessageChannel<Any?>(binaryMessenger, channelName, codec)
    channel.send(listOf(deviceIdArg, characteristicIdArg, offsetArg, valueArg)) {
      if (it is List<*>) {
        if (it.size > 1) {
          callback(Result.failure(FlutterError(it[0] as String, it[1] as String, it[2] as String?)))
        } else {
          val output = it[0] as ReadRequestResult?
          callback(Result.success(output))
        }
      } else {
        callback(Result.failure(createConnectionError(channelName)))
      } 
    }
  }
  fun onWriteRequest(deviceIdArg: String, characteristicIdArg: String, offsetArg: Long, valueArg: ByteArray?, callback: (Result<WriteRequestResult?>) -> Unit)
{
    val separatedMessageChannelSuffix = if (messageChannelSuffix.isNotEmpty()) ".$messageChannelSuffix" else ""
    val channelName = "dev.flutter.pigeon.ble_peripheral.BleCallback.onWriteRequest$separatedMessageChannelSuffix"
    val channel = BasicMessageChannel<Any?>(binaryMessenger, channelName, codec)
    channel.send(listOf(deviceIdArg, characteristicIdArg, offsetArg, valueArg)) {
      if (it is List<*>) {
        if (it.size > 1) {
          callback(Result.failure(FlutterError(it[0] as String, it[1] as String, it[2] as String?)))
        } else {
          val output = it[0] as WriteRequestResult?
          callback(Result.success(output))
        }
      } else {
        callback(Result.failure(createConnectionError(channelName)))
      } 
    }
  }
  fun onCharacteristicSubscriptionChange(deviceIdArg: String, characteristicIdArg: String, isSubscribedArg: Boolean, nameArg: String?, callback: (Result<Unit>) -> Unit)
{
    val separatedMessageChannelSuffix = if (messageChannelSuffix.isNotEmpty()) ".$messageChannelSuffix" else ""
    val channelName = "dev.flutter.pigeon.ble_peripheral.BleCallback.onCharacteristicSubscriptionChange$separatedMessageChannelSuffix"
    val channel = BasicMessageChannel<Any?>(binaryMessenger, channelName, codec)
    channel.send(listOf(deviceIdArg, characteristicIdArg, isSubscribedArg, nameArg)) {
      if (it is List<*>) {
        if (it.size > 1) {
          callback(Result.failure(FlutterError(it[0] as String, it[1] as String, it[2] as String?)))
        } else {
          callback(Result.success(Unit))
        }
      } else {
        callback(Result.failure(createConnectionError(channelName)))
      } 
    }
  }
  fun onAdvertisingStatusUpdate(advertisingArg: Boolean, errorArg: String?, callback: (Result<Unit>) -> Unit)
{
    val separatedMessageChannelSuffix = if (messageChannelSuffix.isNotEmpty()) ".$messageChannelSuffix" else ""
    val channelName = "dev.flutter.pigeon.ble_peripheral.BleCallback.onAdvertisingStatusUpdate$separatedMessageChannelSuffix"
    val channel = BasicMessageChannel<Any?>(binaryMessenger, channelName, codec)
    channel.send(listOf(advertisingArg, errorArg)) {
      if (it is List<*>) {
        if (it.size > 1) {
          callback(Result.failure(FlutterError(it[0] as String, it[1] as String, it[2] as String?)))
        } else {
          callback(Result.success(Unit))
        }
      } else {
        callback(Result.failure(createConnectionError(channelName)))
      } 
    }
  }
  fun onBleStateChange(stateArg: Boolean, callback: (Result<Unit>) -> Unit)
{
    val separatedMessageChannelSuffix = if (messageChannelSuffix.isNotEmpty()) ".$messageChannelSuffix" else ""
    val channelName = "dev.flutter.pigeon.ble_peripheral.BleCallback.onBleStateChange$separatedMessageChannelSuffix"
    val channel = BasicMessageChannel<Any?>(binaryMessenger, channelName, codec)
    channel.send(listOf(stateArg)) {
      if (it is List<*>) {
        if (it.size > 1) {
          callback(Result.failure(FlutterError(it[0] as String, it[1] as String, it[2] as String?)))
        } else {
          callback(Result.success(Unit))
        }
      } else {
        callback(Result.failure(createConnectionError(channelName)))
      } 
    }
  }
  fun onServiceAdded(serviceIdArg: String, errorArg: String?, callback: (Result<Unit>) -> Unit)
{
    val separatedMessageChannelSuffix = if (messageChannelSuffix.isNotEmpty()) ".$messageChannelSuffix" else ""
    val channelName = "dev.flutter.pigeon.ble_peripheral.BleCallback.onServiceAdded$separatedMessageChannelSuffix"
    val channel = BasicMessageChannel<Any?>(binaryMessenger, channelName, codec)
    channel.send(listOf(serviceIdArg, errorArg)) {
      if (it is List<*>) {
        if (it.size > 1) {
          callback(Result.failure(FlutterError(it[0] as String, it[1] as String, it[2] as String?)))
        } else {
          callback(Result.success(Unit))
        }
      } else {
        callback(Result.failure(createConnectionError(channelName)))
      } 
    }
  }
  fun onMtuChange(deviceIdArg: String, mtuArg: Long, callback: (Result<Unit>) -> Unit)
{
    val separatedMessageChannelSuffix = if (messageChannelSuffix.isNotEmpty()) ".$messageChannelSuffix" else ""
    val channelName = "dev.flutter.pigeon.ble_peripheral.BleCallback.onMtuChange$separatedMessageChannelSuffix"
    val channel = BasicMessageChannel<Any?>(binaryMessenger, channelName, codec)
    channel.send(listOf(deviceIdArg, mtuArg)) {
      if (it is List<*>) {
        if (it.size > 1) {
          callback(Result.failure(FlutterError(it[0] as String, it[1] as String, it[2] as String?)))
        } else {
          callback(Result.success(Unit))
        }
      } else {
        callback(Result.failure(createConnectionError(channelName)))
      } 
    }
  }
  fun onConnectionStateChange(deviceIdArg: String, connectedArg: Boolean, callback: (Result<Unit>) -> Unit)
{
    val separatedMessageChannelSuffix = if (messageChannelSuffix.isNotEmpty()) ".$messageChannelSuffix" else ""
    val channelName = "dev.flutter.pigeon.ble_peripheral.BleCallback.onConnectionStateChange$separatedMessageChannelSuffix"
    val channel = BasicMessageChannel<Any?>(binaryMessenger, channelName, codec)
    channel.send(listOf(deviceIdArg, connectedArg)) {
      if (it is List<*>) {
        if (it.size > 1) {
          callback(Result.failure(FlutterError(it[0] as String, it[1] as String, it[2] as String?)))
        } else {
          callback(Result.success(Unit))
        }
      } else {
        callback(Result.failure(createConnectionError(channelName)))
      } 
    }
  }
  fun onBondStateChange(deviceIdArg: String, bondStateArg: BondState, callback: (Result<Unit>) -> Unit)
{
    val separatedMessageChannelSuffix = if (messageChannelSuffix.isNotEmpty()) ".$messageChannelSuffix" else ""
    val channelName = "dev.flutter.pigeon.ble_peripheral.BleCallback.onBondStateChange$separatedMessageChannelSuffix"
    val channel = BasicMessageChannel<Any?>(binaryMessenger, channelName, codec)
    channel.send(listOf(deviceIdArg, bondStateArg)) {
      if (it is List<*>) {
        if (it.size > 1) {
          callback(Result.failure(FlutterError(it[0] as String, it[1] as String, it[2] as String?)))
        } else {
          callback(Result.success(Unit))
        }
      } else {
        callback(Result.failure(createConnectionError(channelName)))
      } 
    }
  }
}
